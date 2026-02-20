package org.example.superheroexercise.repository;

import org.example.superheroexercise.model.Superhero;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SuperheroRepository {
    private final List<Superhero> superheroList = new ArrayList<>();
    private int nextId = 1;

    public SuperheroRepository() throws Exception{
        populateList();
    }

    public Superhero findById(int id){
        for(Superhero superhero : superheroList){
            if (superhero.getId() == id){
                return superhero;
            }
        }
        return null;
    }

    public void save(Superhero superhero) throws IOException {
        superheroList.add(superhero);
        superhero.setId(nextId++);
        addToFile("src/main/resources/static/superheroes.csv", superhero);
    }

    public void populateList() throws Exception{
        for(Superhero superhero : superheroFileReader("src/main/resources/static/superheroes.csv")){
            save(superhero);
        }
    }

    public List<Superhero> superheroFileReader(String filepath) throws Exception{
        List<Superhero> returnList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String line;
        while((line = br.readLine()) != null){
            String[] fieldsOfLine = line.split(",");
            List<String> powers = new ArrayList<>(Arrays.asList(fieldsOfLine).subList(2, fieldsOfLine.length));
            returnList.add(new Superhero(fieldsOfLine[0], fieldsOfLine[1], powers));
        }
        return returnList;
    }

    public List<Superhero> getSuperheroList() {
        return superheroList;
    }

    public void addToFile(String filepath, Superhero superhero) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath);
        fileWriter.append("\n");
        fileWriter.append(superhero.getName().concat(","));
        fileWriter.append(superhero.getHeroName());
        for(String power : superhero.getPowers()){
            fileWriter.append(",".concat(power));
        }
        fileWriter.close();
    }


}
