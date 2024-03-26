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
    private HellRaceRepository hellraceRepository;

    @Autowired
    public HellRunRestController(HellRunnerRepository hellrunnerRepository, HellResultRepository hellresultRepository, HellRaceRepository hellraceRepository) {
        this.hellrunnerRepository = hellrunnerRepository;
        this.hellraceRepository = hellraceRepository;
        this.hellresultRepository = hellresultRepository;
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

    @PostMapping("/updateRace")
    public ResponseEntity updateRace( @RequestBody RaceUpdateRequest raceUpdateRequest) {

        HellRaceEntity race = new HellRaceEntity();

        race.setRaceId(raceUpdateRequest.getRaceId());
        race.setRaceName(raceUpdateRequest.getRaceName());
        race.setRaceKm(raceUpdateRequest.getRaceKm());

        hellraceRepository.save(race);
        return ResponseEntity.ok().build();
    }

    public static class RaceUpdateRequest {
        private long raceId;
        private String raceName;
        private int raceKm;

        public long getRaceId() {        return raceId;     }
        public void setRaceId(long raceId) {
            this.raceId = raceId;
        }

        public String getRaceName() {
            return raceName;
        }
        public void setRaceName(String raceName) {
            this.raceName = raceName;
        }

        public int getRaceKm() {
            return raceKm;
        }
        public void setRaceKm(int raceKm) {     this.raceKm = raceKm;      }
    }


}
