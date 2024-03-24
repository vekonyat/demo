package com.example.demo;

// HellResultEntity.java


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class HellResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "runnerId", nullable = false)
    private HellRunnerEntity runner;

    @ManyToOne
    @JoinColumn(name = "raceId", nullable = false)
    private HellRaceEntity race;

    private int resultTime;

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long race) {
        this.resultId = resultId;
    }

    public HellRaceEntity getRace() {
        return race;
    }

    public void setRace(HellRaceEntity race) {
        this.race = race;
    }


    public HellRunnerEntity getRunner() {
        return runner;
    }

    public void setRunner(HellRunnerEntity runner) {
        this.runner = runner;
    }

    public int getResultTime() {
        return resultTime;
    }

    public void setResultTime(int resultTime) {
        this.resultTime = resultTime;
    }


}
