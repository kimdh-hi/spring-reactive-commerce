package com.example.springreactivech2.controller;

import com.example.springreactivech2.repository.CartRepository;
import com.example.springreactivech2.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public HomeController(CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }
}
