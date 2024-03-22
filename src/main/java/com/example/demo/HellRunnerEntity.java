package com.example.demo;

// HelloEntity.java


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HellRunnerEntity {
    public long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(long runnerId) {
        this.runnerId = runnerId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long runnerId;

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    private String runnerName;

    public int getRunnerAge() {
        return runnerAge;
    }

    public void setRunnerAge(int runnerAge) {
        this.runnerAge = runnerAge;
    }

    private int runnerAge;

    public int getRunnerGender() {
        return runnerGender;
    }

    public void setRunnerGender(int runnerGender) {
        this.runnerGender = runnerGender;
    }

    private int runnerGender;



}
