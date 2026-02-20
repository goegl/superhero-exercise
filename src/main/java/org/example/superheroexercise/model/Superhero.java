package org.example.superheroexercise.model;

import java.util.List;

public class Superhero {
    private String name;
    private List<String> powers;
    private String heroName;
    private String description;

    public Superhero(String name, List<String> powers, String heroName, String description){
        this.name = name;
        this.powers = powers;
        this.heroName = heroName;
        this.description = description;
    }
    public Superhero(){};

    
}
