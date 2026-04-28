package com.example.demo.controller;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    private final PatientRepository repository;

    public PatientController(PatientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/add")
    public String addPatient(@RequestParam String name,
                             @RequestParam int age) {
        repository.save(new Patient(name, age));
        return "redirect:/";
    }

    @GetMapping("/summary")
    public String summary(Model model) {
        model.addAttribute("patients", repository.findAll());
        return "index";
    }
}
