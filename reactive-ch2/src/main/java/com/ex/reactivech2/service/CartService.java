package com.ex.reactivech2.service;

import com.ex.reactivech2.domain.Cart;
import com.ex.reactivech2.domain.CartItem;
import com.ex.reactivech2.repository.CartRepository;
import com.ex.reactivech2.repository.ItemRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public CartService(CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    public Mono<Cart> addToCart(String cartId, String itemId) {
        return cartRepository.findById(cartId)
                .defaultIfEmpty(new Cart(cartId)) // 장바구니가 빈 경우
                .flatMap(cart -> cart.getCartItems().stream() // 장바구니에 상품이 있는 경우
                        .filter(cartItem -> cartItem.getItem().getId().equals(itemId))
                        .findAny()
                        .map(cartItem -> { // 장바구니에 추가할 상품이 이미 있다면
                                cartItem.increment();
                                return Mono.just(cart);
                        })
                        .orElseGet(() -> // 장바구니에 추가할 상품이 없다면
                            itemRepository.findById(itemId)
                                .map(CartItem::new)
                                .doOnNext(cartItem -> cart.getCartItems().add(cartItem))
                                .map(cartItem -> cart)))
                .flatMap(cartRepository::save);
    }
}
