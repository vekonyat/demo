package com.example.demo;

// HelloEntity.java


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class HellRunnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long runnerId;

    private String runnerName;
    private int runnerAge;
    private int runnerGender;

    public HellRunnerEntity() {
    }

    public long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(long runnerId) {
        this.runnerId = runnerId;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public int getRunnerAge() {
        return runnerAge;
    }

    public void setRunnerAge(int runnerAge) {
        this.runnerAge = runnerAge;
    }

    public int getRunnerGender() {
        return runnerGender;
    }

    public void setRunnerGender(int runnerGender) {
        this.runnerGender = runnerGender;
    }

}
