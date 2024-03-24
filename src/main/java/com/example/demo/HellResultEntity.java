package com.example.demo;

// HellResultEntity.java


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HellResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String raceName;
    private long raceId;
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
