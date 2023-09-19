package Superhero;

import java.util.ArrayList;

public class Database {


    public ArrayList<Superhero> superheroes = new ArrayList<Superhero>();
    public void tilføjSuperhelt(String name, String realName, String superPower, int yearCreated, String race, double strength) {
        superheroes.add(new Superhero(name, realName, superPower, yearCreated, race, strength));
    }

    public ArrayList<Superhero> getSuperhelte() {
        return superheroes;
    }

    public void deleteSuperhero(String name) {
        for (int i = 0; i < superheroes.size(); i++) {
            Superhero superhero = superheroes.get(i);
            if (superhero.getName().equals(name)) {
                superheroes.remove(i);
                break;
            }
        }
    }

}