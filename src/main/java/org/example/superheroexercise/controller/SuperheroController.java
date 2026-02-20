package org.example.superheroexercise.controller;

import org.example.superheroexercise.model.Superhero;
import org.example.superheroexercise.service.SuperheroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/heroes")
public class SuperheroController {
    private final SuperheroService service;

    public SuperheroController(SuperheroService service){
        this.service = service;
    }

    @GetMapping
    public String showAllHeroes(Model model){
        model.addAttribute("heroes", service.getAllHeroes());
        return"allHeroes";
    }

    @GetMapping("/add")
    public String addHero(Model model){
        Superhero superhero = new Superhero();
        model.addAttribute("superHero", superhero);
        model.addAttribute("listOfPowers", superhero.getPowers());
        return "addHeroForm";
    }

}
