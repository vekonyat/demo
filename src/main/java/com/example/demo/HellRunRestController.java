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
    private final HellRunnerRepository hellrunnerRepository;

    @Autowired
    private final HellResultRepository hellresultRepository;

    @Autowired
    private final HellRaceRepository hellraceRepository;

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
    public ResponseEntity addRunner(@RequestBody HellRunnerEntity runnerData) {

        hellrunnerRepository.save(runnerData);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getRaceRunners/{id}")
    public List<Object[]> getRunnerIdsByRaceId(@PathVariable Long id) {
        return hellresultRepository.findRunnerNamesAndResultTimeByRaceId(id);
    }

    @PostMapping("/updateRace")
    public ResponseEntity updateRace(@RequestBody RaceUpdateRequest raceUpdateRequest) {

        HellRaceEntity race = new HellRaceEntity();

        race.setRaceId(raceUpdateRequest.getRaceId());
        race.setRaceName(raceUpdateRequest.getRaceName());
        race.setRaceKm(raceUpdateRequest.getRaceKm());

        hellraceRepository.save(race);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addResult")
    public ResponseEntity addResult(@RequestBody AddResultEntity resultData) {
        HellResultEntity newResult = new HellResultEntity();

        newResult.setResultTime(resultData.getResultTime());
        newResult.setRace(hellraceRepository.findById(resultData.getRaceId()).orElse(null));
        newResult.setRunner(hellrunnerRepository.findById(resultData.getRunnerId()).orElse(null));
        hellresultRepository.save(newResult);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/getAverageTime/{id}")
    public double getAverageTimeByRaceId(@PathVariable Long id) {
        List<Object[]> dataList = hellresultRepository.getTimesByRaceId(id);
        double sum = 0;
        int count = 0;

        for (Object[] array : dataList) {
            for (Object obj : array) {
                sum += ((Number) obj).doubleValue();
                count++;
            }
        }

        return sum / count;
    }

    public static class RaceUpdateRequest {
        private long raceId;
        private String raceName;
        private int raceKm;

        public long getRaceId() {
            return raceId;
        }

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

        public void setRaceKm(int raceKm) {
            this.raceKm = raceKm;
        }
    }

    public static class AddResultEntity {
        private long resultId;
        private long raceId;
        private long runnerId;
        private int resultTime;

        public long getResultId() {
            return resultId;
        }

        public void setResultId(long resultId) {
            this.resultId = resultId;
        }

        public long getRaceId() {
            return raceId;
        }

        public void setRaceId(long raceId) {
            this.raceId = raceId;
        }

        public long getRunnerId() {
            return runnerId;
        }

        public void setRunnerId(long runnerId) {
            this.runnerId = runnerId;
        }

        public int getResultTime() {
            return resultTime;
        }

        public void setResultTime(int resultTime) {
            this.resultTime = resultTime;
        }
    }

}
