package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vatt1/hellrun")
public class HellRunRestController {

    @Autowired
    private HellRunnerRepository hellrunnerRepository;

    @Autowired
    public HellRunRestController(HellRunnerRepository hellrunnerRepository) {
        this.hellrunnerRepository = hellrunnerRepository;
    }

    @GetMapping("/getRunners")
    public List<HellRunnerEntity> getAllRunners_API() {
        return hellrunnerRepository.findAll();
    }
}
