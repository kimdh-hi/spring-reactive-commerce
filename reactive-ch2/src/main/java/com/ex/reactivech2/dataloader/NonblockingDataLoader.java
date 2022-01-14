package com.ex.reactivech2.dataloader;

import com.ex.reactivech2.domain.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class NonblockingDataLoader {

    @Bean
    CommandLineRunner initialize(MongoOperations mongo) {
        return args -> {
            mongo.save(new Item("itemA", 15_000));
            mongo.save(new Item("itemB", 20_000));
        };
    }
}
