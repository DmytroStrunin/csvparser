package com.example.csvparser.controller;

import com.example.csvparser.entity.Dummy;
import com.example.csvparser.repository.DummyRepository;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DummyController {

    private final DummyRepository repository;



    public DummyController(DummyRepository repository) {
        this.repository = repository;

    }

    @GetMapping("/dummy")
    List<Dummy> all() {
        return repository.findAll();
    }

    @PostMapping("/dummy")
    Dummy newDummy(@RequestBody Dummy newDummy) {
        return repository.save(newDummy);
    }


    @GetMapping("/dummy/{id}")
    Dummy one(@PathVariable Long id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));
    }


    @PutMapping("/dummy/{id}")
    Dummy replaceDummy(@RequestBody Dummy newDummy, @PathVariable Long id) {

        return repository.findById(id)
                .map(dummy -> {
                    dummy.setData(newDummy.getData());
                    return repository.save(dummy);
                })
                .orElseGet(() -> {
                    newDummy.setId(id);
                    return repository.save(newDummy);
                });
    }

    @DeleteMapping("/dummy/{id}")
    void deleteDummy(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
