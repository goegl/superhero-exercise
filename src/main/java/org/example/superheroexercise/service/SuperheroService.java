package org.example.superheroexercise.service;

import org.example.superheroexercise.model.Superhero;
import org.example.superheroexercise.repository.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SuperheroService {
    private final SuperheroRepository superheroRepository;

    public SuperheroService(SuperheroRepository superheroRepository){
        this.superheroRepository = superheroRepository;
    }

    public List<Superhero> getAllHeroes(){
        return superheroRepository.getSuperheroList();
    }

    public Superhero findById(int id){
        return superheroRepository.findById(id);
    }

    public Superhero addHero(Superhero superhero) throws IOException {
       superheroRepository.save(superhero);
       return superhero;
    }
}
