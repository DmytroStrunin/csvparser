package com.example.csvparser.repository;

import com.example.csvparser.entity.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DummyRepository extends JpaRepository<Dummy, Long> {
}
