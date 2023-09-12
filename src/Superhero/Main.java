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
                9. Afslut
                """);

        int brugerValg = _keyboard.nextInt();
        _keyboard.nextLine();
        håndterBrugerValg(brugerValg);
        System.out.println(brugerValg);
    }

    public static void håndterBrugerValg(int brugerValg) {
        switch (brugerValg) {
            case 1:
                TilføjSuperhelt();
                break;
            case 2:
                VisSuperhelte();
                break;
            default:
                System.out.println(brugerValg);
        }
    }

    private static void VisSuperhelte() {
        ArrayList<Superhero> superhelte = db.getSuperhelte();
        for (int i = 0; i < superhelte.size(); i++) {
            Superhero superhero = superhelte.get(i);
            System.out.println(superhero.getName());
        }
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
        _keyboard.nextLine();

        System.out.println("Hvad er superheltens race?");
        String race = _keyboard.next();

        System.out.println("Hvad er superheltens styrke?");
        double strength = _keyboard.nextDouble();

        db.tilføjSuperhelt(name, realName, superPower, yearCreated, race, strength);
        VisMenu();
    }

}
