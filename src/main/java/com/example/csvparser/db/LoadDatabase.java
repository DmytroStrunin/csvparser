package com.example.csvparser.db;

import com.example.csvparser.entity.Dummy;
import com.example.csvparser.repository.DummyRepository;
import com.example.csvparser.util.ReadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(DummyRepository repository) {

        return args -> {
            final Dummy entity = new Dummy();
            entity.setData("Name");
            final Dummy entity1 = new Dummy();
            entity1.setData("qwe");
            log.info("Preloading " + repository.save(entity));
            log.info("Preloading " + repository.save(entity1));
            new ReadFile(repository).read();
        };

    }
}