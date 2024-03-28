package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HellResultRepository extends JpaRepository<HellResultEntity, Long> {

    @Query("SELECT r.runner.runnerName, r.resultTime FROM HellResultEntity r WHERE r.race.raceId = ?1 ORDER BY r.resultTime")
    List<Object[]> findRunnerNamesAndResultTimeByRaceId(Long raceId);

    @Query("SELECT r.resultTime FROM HellResultEntity r WHERE r.race.raceId = ?1 ")
    List<Object[]> getTimesByRaceId(Long raceId);
}