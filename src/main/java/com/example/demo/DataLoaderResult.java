package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderResult implements CommandLineRunner {

    private final HellRunnerRepository hellrunnerRepository;
    private final HellResultRepository hellresultRepository;
    private final HellRaceRepository hellraceRepository;

    @Autowired
    public DataLoaderResult(HellResultRepository hellresultRepository, HellRaceRepository hellraceRepository, HellRunnerRepository hellrunnerRepository) {
        this.hellrunnerRepository = hellrunnerRepository;
        this.hellresultRepository = hellresultRepository;
        this.hellraceRepository = hellraceRepository;
    }

    @Override
    public void run(String... args) {
        // create result entities

        HellRunnerEntity hellrunnerEntity1 = new HellRunnerEntity();
        hellrunnerEntity1.setRunnerId(1);
        hellrunnerEntity1.setRunnerName("Tóni");
        hellrunnerEntity1.setRunnerAge(35);
        hellrunnerEntity1.setRunnerGender(1);

        hellrunnerRepository.save(hellrunnerEntity1);

        HellRunnerEntity hellrunnerEntity2 = new HellRunnerEntity();
        hellrunnerEntity2.setRunnerId(2);
        hellrunnerEntity2.setRunnerName("Barbi");
        hellrunnerEntity2.setRunnerAge(35);
        hellrunnerEntity2.setRunnerGender(2);

        hellrunnerRepository.save(hellrunnerEntity2);

        HellRunnerEntity hellrunnerEntity3 = new HellRunnerEntity();
        hellrunnerEntity3.setRunnerId(3);
        hellrunnerEntity3.setRunnerName("Ádám");
        hellrunnerEntity3.setRunnerAge(35);
        hellrunnerEntity3.setRunnerGender(1);

        hellrunnerRepository.save(hellrunnerEntity3);

        HellRunnerEntity hellrunnerEntity4 = new HellRunnerEntity();
        hellrunnerEntity4.setRunnerId(4);
        hellrunnerEntity4.setRunnerName("Viktor");
        hellrunnerEntity4.setRunnerAge(35);
        hellrunnerEntity4.setRunnerGender(1);

        hellrunnerRepository.save(hellrunnerEntity4);

        HellRaceEntity hellraceEntity1 = new HellRaceEntity();
        hellraceEntity1.setRaceId(1);
        hellraceEntity1.setRaceName("Race in hell");
        hellraceEntity1.setRaceKm(100);

        hellraceRepository.save(hellraceEntity1);

        HellRaceEntity hellraceEntity2 = new HellRaceEntity();
        hellraceEntity2.setRaceId(2);
        hellraceEntity2.setRaceName("Race in Heaven");
        hellraceEntity2.setRaceKm(150);

        hellraceRepository.save(hellraceEntity2);

        HellResultEntity hellresultEntity1 = new HellResultEntity();
        hellresultEntity1.setResultId(1L);
        hellresultEntity1.setRace(hellraceEntity1);
        hellresultEntity1.setRunner(hellrunnerEntity1);
        hellresultEntity1.setResultTime(3700);

        hellresultRepository.save(hellresultEntity1);

        HellResultEntity hellresultEntity2 = new HellResultEntity();
        hellresultEntity1.setResultId(2L);
        hellresultEntity2.setRace(hellraceEntity1);
        hellresultEntity2.setRunner(hellrunnerEntity2);
        hellresultEntity2.setResultTime(3100);

        hellresultRepository.save(hellresultEntity2);

        HellResultEntity hellresultEntity3 = new HellResultEntity();
        hellresultEntity1.setResultId(3L);
        hellresultEntity3.setRace(hellraceEntity1);
        hellresultEntity3.setRunner(hellrunnerEntity3);
        hellresultEntity3.setResultTime(3200);

        hellresultRepository.save(hellresultEntity3);

        HellResultEntity hellresultEntity4 = new HellResultEntity();
        hellresultEntity1.setResultId(4L);
        hellresultEntity4.setRace(hellraceEntity2);
        hellresultEntity4.setRunner(hellrunnerEntity1);
        hellresultEntity4.setResultTime(3600);

        hellresultRepository.save(hellresultEntity4);

        HellResultEntity hellresultEntity5 = new HellResultEntity();
        hellresultEntity1.setResultId(5L);
        hellresultEntity5.setRace(hellraceEntity2);
        hellresultEntity5.setRunner(hellrunnerEntity2);
        hellresultEntity5.setResultTime(3400);

        hellresultRepository.save(hellresultEntity5);

        HellResultEntity hellresultEntity6 = new HellResultEntity();
        hellresultEntity1.setResultId(6L);
        hellresultEntity6.setRace(hellraceEntity2);
        hellresultEntity6.setRunner(hellrunnerEntity3);
        hellresultEntity6.setResultTime(3500);

        hellresultRepository.save(hellresultEntity6);

    }
}