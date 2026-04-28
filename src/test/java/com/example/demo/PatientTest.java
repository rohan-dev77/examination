package com.example.demo;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository repository;

    @Test
    void testInsertAndFetch() {
        Patient p = new Patient("John", 30);
        Patient saved = repository.save(p);

        assertNotNull(saved.getId());

        Patient fetched = repository.findById(saved.getId()).orElse(null);

        assertNotNull(fetched);
        assertEquals("John", fetched.getName());
        assertEquals(30, fetched.getAge());
    }
}