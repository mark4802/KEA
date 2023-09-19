package Superhero;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Database db = new Database();
    static Scanner _keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        VisMenu();
    }

    private static void VisMenu() {
        System.out.println("""
                1. Opret superhelt
                2. Vis superhelte
                3. Find superhelte
                4. Slet superhelt
                9. Afslut
                """);

        int brugerValg = _keyboard.nextInt();
        _keyboard.nextLine();
        håndterBrugerValg(brugerValg);
    }

    public static void håndterBrugerValg(int brugerValg) {
        switch (brugerValg) {
            case 1 -> TilføjSuperhelt();
            case 2 -> VisSuperhelte();
            case 3 -> Search();
            case 4 -> SletSuperhelt();
            case 9 -> {
                System.out.println("Programmet er afsluttet.");
                System.exit(0);
            }
            default -> {
                System.out.println("\"" + brugerValg + "\"" + " er ikke en valgmulighed. Prøv igen");
                VisMenu();
            }
        }
    }

    private static void SletSuperhelt() {
        System.out.print("Indtast navnet på den superhelt du vil slette: ");
        String name = _keyboard.next();

        db.deleteSuperhero(name);

        System.out.println("Superhelten er blevet slettet.");
        VisMenu();
    }

    private static void VisSuperhelte() {
        ArrayList<Superhero> superhelte = db.getSuperhelte();
        for (int i = 0; i < superhelte.size(); i++) {
            Superhero superhero = superhelte.get(i);
            PrintSuperhero(superhero);
        }
        VisMenu();
    }

    private static void PrintSuperhero(Superhero superhero) {
        System.out.println(
                "Navn: " + superhero.getName() +
                        "     Rigtigt navn: " + superhero.getrealName() +
                        "     Superkraft: " + superhero.getsuperPower() +
                        "     År skabt: " + superhero.getyearCreated() +
                        "     Race: " + superhero.getRace() +
                        "     Styrke: " + superhero.getstrength()
        );
    }


    private static void TilføjSuperhelt() {
        System.out.println("Hvad er superheltens navn?");
        String name = _keyboard.next();

        System.out.println("Hvad er superheltens rigtige navn?");
        String realName = _keyboard.next();

        System.out.println("Hvad er superheltens superkraft?");
        String superPower = _keyboard.next();

        System.out.println("Hvilket år er superhelten skabt?");
        int yearCreated = _keyboard.nextInt();

        System.out.println("Hvad er superheltens race?");
        String race = _keyboard.next();

        System.out.println("Hvad er superheltens styrke?");
        double strength = _keyboard.nextDouble();

        db.tilføjSuperhelt(name, realName, superPower, yearCreated, race, strength);
        VisMenu();
    }

    private static void Search() {
        System.out.print("Indtast søgeord: ");
        String searchCriteria = _keyboard.next();
        ArrayList<Superhero> matchingSuperheroes = GetMatchingSuperheroes(searchCriteria.toLowerCase());

        if (matchingSuperheroes.size() <= 0)
            System.out.println("Ingen superhelt ved navn " + "\"" + searchCriteria + "\"" + " fundet.");

        for (int i = 0; i < matchingSuperheroes.size(); i++) {
            Superhero superhero = matchingSuperheroes.get(i);
            PrintSuperhero(superhero);
        }
        VisMenu();
    }

    private static ArrayList<Superhero> GetMatchingSuperheroes(String searchCriteria) {
        ArrayList<Superhero> superheroes = db.getSuperhelte();
        ArrayList<Superhero> matchingSuperheroes = new ArrayList<Superhero>();


        for (int i = 0; i < superheroes.size(); i++) {
            Superhero superhero = superheroes.get(i);
            if (superhero.getName().toLowerCase().contains(searchCriteria)) {
                matchingSuperheroes.add(superhero);
            }
        }

        return matchingSuperheroes;

    }

}
