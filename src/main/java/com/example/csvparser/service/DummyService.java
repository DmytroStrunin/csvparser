package com.example.csvparser.service;

import com.example.csvparser.repository.DummyRepository;
import org.springframework.stereotype.Service;

@Service
public class DummyService {
    private DummyRepository dummyRepository;

    public DummyService(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }
}
