package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HellRunController {

    @Autowired
    private HellRaceRepository hellraceRepository;
    @Autowired
    private HellRunnerRepository hellrunnerRepository;

    @Autowired
    private HellResultRepository hellresultRepository;

    @Autowired
    public HellRunController(HellRunnerRepository hellrunnerRepository, HellResultRepository hellresultRepository, HellRaceRepository hellraceRepository) {
        this.hellrunnerRepository = hellrunnerRepository;
        this.hellraceRepository = hellraceRepository;
        this.hellresultRepository = hellresultRepository;
    }
    @GetMapping("/races")
    public String getAllRaces(Model model) {
        List<HellRaceEntity> races = hellraceRepository.findAll();
        model.addAttribute("hellraces", races);
        return "hellraces";
    }

    @GetMapping("/")
    public String hellrace() {
        return "hellrace";
    }
    @GetMapping("/getRaceRunners/{id}")
    public String getRunnerIdsByRaceId(@PathVariable Long id, Model model) {
        List<Object[]> runner = hellresultRepository.findRunnerNamesAndResultTimeByRaceId(id);
        model.addAttribute("runners", runner);
        return "runners";
    }
}
