package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vatt1/hellrun")
public class HellRunRestController {

    @Autowired
    private HellRunnerRepository hellrunnerRepository;

    @Autowired
    private HellResultRepository hellresultRepository;

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

        hellrunnerRepository.save(runnerData);
            return ResponseEntity.ok().build();

    }

    @GetMapping("/getRaceRunners/{id}")
    public List<Object[]> getRunnerIdsByRaceId(@PathVariable Long id) {
      return hellresultRepository.findRunnerIdsAndResultTimeByRaceId(id);

    }


}
