package com.example.rps.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    private String[] choices = {"Piedra", "Papel", "Tijeras"};

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/play")
    public String play(@RequestParam("choice") String userChoice, Model model) {
        String computerChoice = choices[new Random().nextInt(choices.length)];
        String result = determineWinner(userChoice, computerChoice);

        model.addAttribute("userChoice", userChoice);
        model.addAttribute("computerChoice", computerChoice);
        model.addAttribute("result", result);

        return "index";
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Empate";
        }
        switch (userChoice) {
            case "Piedra":
                return (computerChoice.equals("Tijeras")) ? "Ganaste" : "Perdiste";
            case "Papel":
                return (computerChoice.equals("Piedra")) ? "Ganaste" : "Perdiste";
            case "Tijeras":
                return (computerChoice.equals("Papel")) ? "Ganaste" : "Perdiste";
            default:
                return "Opción inválida";
        }
    }
}
