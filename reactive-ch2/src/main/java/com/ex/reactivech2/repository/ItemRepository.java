package com.ex.reactivech2.repository;

import com.ex.reactivech2.domain.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
    
}
