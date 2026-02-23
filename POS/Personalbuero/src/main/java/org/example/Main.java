package org.example;

import java.time.Year;

public class Main {
    static void main() {
        //Mitarbeiter mitarbeiter = new Mitarbeiter();
        Mitarbeiter mitarbeiter = new Mitarbeiter("Anna", Year.of(2001), Year.now());
        System.out.println(mitarbeiter);
        System.out.println();
        Personalbuero personalbuero = new Personalbuero();
        System.out.println(personalbuero);
        System.out.println();
        System.out.println(personalbuero.aufnehmen(null));
        System.out.println();
        System.out.println(personalbuero.aufnehmen(mitarbeiter));
        System.out.println(personalbuero);
        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Hanna", Year.of(2002), Year.now());
        personalbuero.aufnehmen(mitarbeiter1);
        personalbuero.aufnehmen(mitarbeiter1);
        System.out.println(personalbuero);
        System.out.println();

    }













}
