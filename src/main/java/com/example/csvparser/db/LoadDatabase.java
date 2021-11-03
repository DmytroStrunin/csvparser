package com.example.csvparser.db;

import com.example.csvparser.repository.DummyRepository;
import com.example.csvparser.util.ReadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(DummyRepository repository) {

        return args -> {
            new ReadFile(repository).read();
        };

    }
}