// WARNING: This file is auto-generated and any changes to it will be overwritten

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
 

 

public class Auto {
    private String name;
    private int eigengewicht;
    private Person fahrer;
    private Person beifahrer;
    private Person rueckbank;

    // Standard-Konstruktor
    public Auto() {
        setName("n/a");
        setEigengewicht(1300);
    }

    // Konstruktor mit Parametern
    public Auto(String name, int eigengewicht) {
        setName(name);
        setEigengewicht(eigengewicht);
    }

    public String getName() {
        return name;
    }

    public int getEigengewicht() {
        return eigengewicht;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name darf nicht null sein");
        }
        this.name = name;
    }

    public void setEigengewicht(int eigengewicht) {
        if (eigengewicht < 600 || eigengewicht > 3000) {
            throw new IllegalArgumentException("Eigengewicht muss zwischen 600 und 3000 liegen");
        }
        this.eigengewicht = eigengewicht;
    }

   

     // Personen einsteige
    public void einsteigen(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Parameter person darf nicht null sein!");
        }

        // Person darf nicht doppelt im Auto sein
        if (person.equals(fahrer) || person.equals(beifahrer) || person.equals(rueckbank)) {
            throw new IllegalStateException("Diese Person sitzt schon im Auto");
        }

        // freien Platz suchen
        if (fahrer == null) {
            fahrer = person;
            return;
        }
        if (beifahrer == null) {
            beifahrer = person;
            return;
        }
        if (rueckbank == null) {
            rueckbank = person;
            return;
        }

        throw new IllegalStateException("Das Auto ist voll!");
    }

    // Personen aussteigen
    public void aussteigen(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Parameter person darf nicht null sein");
        }

        if (fahrer == person) {
            fahrer = null;
            return;
        }
        if (beifahrer == person) {
            beifahrer = null;
            return;
        }
        if (rueckbank == person) {
            rueckbank = null;
            return;
        }

        throw new IllegalStateException("Person ist nicht im Auto!");
    }

    public void aussteigen(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name darf nicht null sein!");
        }

        if (fahrer != null && name.equals(fahrer.getName())) {
            fahrer = null;
            return;
        }
        if (beifahrer != null && name.equals(beifahrer.getName())) {
            beifahrer = null;
            return;
        }
        if (rueckbank != null && name.equals(rueckbank.getName())) {
            rueckbank = null;
            return;
        }

        throw new IllegalStateException("Person mit Name '" + name + "' ist nicht im Auto!");
    }


    // ========== Zusatzmethoden ==========
    public int gesamtGewicht() {
        int gesamt = getEigengewicht();

        if (fahrer != null) gesamt += fahrer.getGewicht();
        if (beifahrer != null) gesamt += beifahrer.getGewicht();
        if (rueckbank != null) gesamt += rueckbank.getGewicht();

        return gesamt;
    }

    public void printAuto() {
        System.out.println("Auto: " + name + ", Eigengewicht: " + eigengewicht);
        System.out.println("------------------------------------------");

        System.out.print("Fahrer: ");
        if (fahrer != null) fahrer.print(); else System.out.println(" --frei--");

        System.out.print("Beifahrer: ");
        if (beifahrer != null) beifahrer.print(); else System.out.println(" --frei--");

        System.out.print("Rueckbank: ");
        if (rueckbank != null) rueckbank.print(); else System.out.println(" --frei--");
    }
}