package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DataLoaderRunner implements CommandLineRunner {

    private final HellRunnerRepository hellrunnerRepository;


    @Autowired
    public DataLoaderRunner(HellRunnerRepository hellrunnerRepository) {
        this.hellrunnerRepository = hellrunnerRepository;
    }


    @Override
    public void run(String... args) {
        // create default runner entity

        HellRunnerEntity hellrunnerEntity = new HellRunnerEntity();
        hellrunnerEntity.setRunnerId(1);
        hellrunnerEntity.setRunnerName("Tóni");
        hellrunnerEntity.setRunnerGender(1);

        hellrunnerRepository.save(hellrunnerEntity);

        HellRunnerEntity hellrunnerEntity2 = new HellRunnerEntity();
        hellrunnerEntity2.setRunnerId(2);
        hellrunnerEntity2.setRunnerName("Barbi");
        hellrunnerEntity2.setRunnerGender(2);

        hellrunnerRepository.save(hellrunnerEntity2);

        HellRunnerEntity hellrunnerEntity3 = new HellRunnerEntity();
        hellrunnerEntity3.setRunnerId(3);
        hellrunnerEntity3.setRunnerName("Ádám");
        hellrunnerEntity3.setRunnerGender(1);

        hellrunnerRepository.save(hellrunnerEntity3);

        HellRunnerEntity hellrunnerEntity4 = new HellRunnerEntity();
        hellrunnerEntity4.setRunnerId(4);
        hellrunnerEntity4.setRunnerName("Viktor");
        hellrunnerEntity4.setRunnerGender(1);

        hellrunnerRepository.save(hellrunnerEntity4);

    }
}

