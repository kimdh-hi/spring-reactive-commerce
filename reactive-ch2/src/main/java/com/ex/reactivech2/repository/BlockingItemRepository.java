package com.ex.reactivech2.repository;

import com.ex.reactivech2.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface BlockingItemRepository extends CrudRepository<Item, String> {
}
