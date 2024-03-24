package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderRace implements CommandLineRunner {

    private final HellRaceRepository hellraceRepository;

    @Autowired
    public DataLoaderRace(HellRaceRepository hellraceRepository) {
        this.hellraceRepository = hellraceRepository;
    }

    @Override
    public void run(String... args) {
        // create race entities

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

    }
}