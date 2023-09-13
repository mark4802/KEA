package Superhero;

import java.util.ArrayList;
import java.util.Arrays;

public class Database {

    public ArrayList<Superhero> superheroes = new ArrayList<Superhero>();

    public void tilføjSuperhelt(String name, String realName, String superPower, int yearCreated, String race, double strength) {
        superheroes.add(new Superhero(name, realName, superPower, yearCreated, race, strength));
    }

    public ArrayList<Superhero> getSuperhelte() {
        return superheroes;
    }

}