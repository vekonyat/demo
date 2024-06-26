package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HellRunController {

    @Autowired
    private final HellRaceRepository hellraceRepository;
    @Autowired
    private final HellRunnerRepository hellrunnerRepository;

    @Autowired
    private final HellResultRepository hellresultRepository;

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
    public String hellRace() {
        return "hellrace";
    }
    @GetMapping("/getRaceRunners/{id}")
    public String getRunnerIdsByRaceId(@PathVariable Long id, Model model) {
        List<Object[]> runner = hellresultRepository.findRunnerNamesAndResultTimeByRaceId(id);
        model.addAttribute("runners", runner);
        return "runners";
    }

    @GetMapping("/newrace")
    public String getNewRace(Model model) {
        model.addAttribute("raceData", new HellRaceEntity());
        return "newrace";
    }

    @PostMapping("/addnewrace")
    public String addRace(@ModelAttribute HellRaceEntity raceData) {
        HellRaceEntity newRace = new HellRaceEntity();

        newRace.setRaceName(raceData.getRaceName());
        newRace.setRaceKm(raceData.getRaceKm());
        if (raceData.getRaceName() !=null && raceData.getRaceKm() > 0) {
            hellraceRepository.save(newRace);
        }
        // not adding new race if data is invalid
            return "redirect:/races";
    }
}
