package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HellRunController {

    @Autowired
    private HellRunnerRepository hellrunnerRepository;

    @GetMapping("/runners")
    public String getAllRunners(Model model) {
        List<HellRunnerEntity> runners = hellrunnerRepository.findAll();
        model.addAttribute("hellrunners", runners);
        return "hellrunners";
    }
}
