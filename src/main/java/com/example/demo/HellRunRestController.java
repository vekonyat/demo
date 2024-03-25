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

    @PostMapping("/addRunner")
    public ResponseEntity addRunner( @RequestBody HellRunnerEntity runnerData) {
//        HellRunnerEntity hellrunnerEntity = new HellRunnerEntity();
//        hellrunnerEntity.setRunnerId(runnerData.getRunnerId());
//        hellrunnerEntity.setRunnerName(runnerData.getRunnerName());
//        hellrunnerEntity.setRunnerGender(runnerData.getRunnerGender());

        hellrunnerRepository.save(runnerData);
            return ResponseEntity.ok().build();

    }
}
