package org.example.superheroexercise.model;

import java.util.List;

public class Superhero {
    private String name;
    private List<String> powers;
    private String heroName;

    private int id;

    public Superhero(String name, String heroName, List<String> powers) {
        this.name = name;
        this.powers = powers;
        this.heroName = heroName;
    }

    public Superhero() {
    }

    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPowers() {
        return powers;
    }

    public void setPowers(List<String> powers) {
        this.powers = powers;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "name='" + name + '\'' +
                ", powers=" + powers +
                ", heroName='" + heroName + '\'' +
                ", id=" + id +
                '}';
    }
}
