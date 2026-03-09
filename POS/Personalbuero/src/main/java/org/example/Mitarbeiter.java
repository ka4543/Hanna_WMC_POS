package org.example;

import java.time.Year;

public abstract class Mitarbeiter
{

    private String name;
    private Year gebJahr;
    private Year eintrJahr;

    public Mitarbeiter(String name, Year gebJahr, Year eintrJahr) {
        setName(name);
        setGebJahr(gebJahr);
        setEintrJahr(eintrJahr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getGebJahr() {
        return gebJahr;
    }

    public void setGebJahr(Year gebJahr) {
        if (gebJahr == null) {
            throw new IllegalArgumentException("Fehler: null");
        }
        if (gebJahr.isAfter(Year.now())) { // in der Zukunft
            throw new IllegalArgumentException("Fehler: liegt in der Zukunft");
        }
        this.gebJahr = gebJahr;
    }

    public Year getEintrJahr() {
        return eintrJahr;
    }

    public void setEintrJahr(Year eintrJahr) {
        if (eintrJahr == null) {
            throw new IllegalArgumentException("Fehler: null");
        }
        if (eintrJahr.isAfter(Year.now())) { // in der Zukunft
            throw new IllegalArgumentException("Fehler: liegt in der Zukunft");
        }
        this.eintrJahr = eintrJahr;
    }

    public int berechneAlter() {
        return Year.now().getValue() - gebJahr.getValue();
    }

    public int berechneDienstalter() {
        return Year.now().getValue() - eintrJahr.getValue();
    }

    public double berechneGehalt() {
        return 1500.0 + berechneDienstalter()*50.0;
    }

    public double berechnePraemie() {
        return switch (berechneDienstalter()) {
            case 15 -> berechneGehalt(); // break;
            case 20 -> berechneGehalt() * 2; //break;
            case 25 -> berechneGehalt() * 3; // break;
            case 50 -> berechneGehalt() * 7; // break; // 14 Gehälter / 2 -> 7
            default -> 0.0;
        };
    }

    @Override
    // Name: Anna, Geb.Jahr: 2001, Alter: 23, Eintr.Jahr: 2024, Dienstalter: 0, Gehalt: 1500.0
    public String toString() {
        return "Name: " + name +
                ", Geb.Jahr: " + gebJahr +
                ", Alter: " + berechneAlter() +
                ", Eintr.Jahr: " + eintrJahr +
                ", Dienstalter: " + berechneDienstalter() +
                ", Gehalt: " + berechneGehalt();
    }

    public void print() {
        System.out.println(this);
    }


//wichtig für plü

//abstract ->muss immer ganze klasse sein
// immer ; nach abstracht kein {}

/*

funktion interface-> beschreibt nur eine methode
naturliche ordnung-> alphabetisch und bei zahlen aufsteigend-> comperable mit compareTo
class instanzieren-> interface implemtieren mit implements
bei override methode mit gleichen namen muss man den datentyp achten -> beim testen zb string bei null2*/








}
