package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HellRunController {

    @Autowired
    private HellRaceRepository hellraceRepository;

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
}
