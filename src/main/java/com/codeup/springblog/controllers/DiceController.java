package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String showDicePage(){
        return "/roll-dice";
    }

    @PostMapping("/roll-dice{n}")
    public String diceGuess(@RequestParam(name = "dice") @PathVariable String dice, Model model) {
        Random random = new Random();
        int n = random.nextInt(6) + 1;
        model.addAttribute("dice", "You guessed " + dice + "!" +
                " The dice rolled " + n + "!");
        return "roll-dice";
    }
}
