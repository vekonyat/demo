package com.example.demo;

// HelloEntity.java


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HellRaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
