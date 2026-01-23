package at.spengergasse;

import java.util.ArrayList;

public class Parkhaus {

    //  Liste speichert Objekte von Auto
    private ArrayList<Auto> parkplaetze;
    private int kapazitaet;

    public Parkhaus(int kapazitaet) {
        if (kapazitaet < 1) {
            throw new IllegalArgumentException("Kapazität muss mindestens 1 sein.");
        }
        this.kapazitaet = kapazitaet;
        this.parkplaetze = new ArrayList<>(kapazitaet);

        // Liste am Anfang mit null,
        for (int i = 0; i < kapazitaet; i++) {
            parkplaetze.add(null);
        }
    }

    public Integer findeFreienPlatz() {
        for (int i = 0; i < parkplaetze.size(); i++) {
            if (parkplaetze.get(i) == null) {
                return i;
            }
        }
        return null;
    }

    public boolean parkeAuto(String kennzeichen) {
        Auto zuParkendes;
        try {
            zuParkendes = new Auto(kennzeichen);
        } catch (IllegalArgumentException e) {
            return false;
        }

        Integer freierPlatz = findeFreienPlatz();
        if (freierPlatz != null) {
            parkplaetze.set(freierPlatz, zuParkendes);
            return true;
        }
        return false;
    }

    public Integer findeAuto(String kennzeichen) {
        if (kennzeichen == null) throw new NullPointerException("Kennzeichen ist null");
        if (kennzeichen.trim().isEmpty()) throw new IllegalArgumentException("Kennzeichen ist leer");

        for (int i = 0; i < parkplaetze.size(); i++) {
            Auto a = parkplaetze.get(i);
            if (a != null && a.getKennzeichen().equals(kennzeichen)) {
                return i;
            }
        }
        return null;
    }

    public Auto verlasseParkplatz(String kennzeichen) {
        Integer platz = findeAuto(kennzeichen);
        if (platz == null) return null;

        Auto verlassendes = parkplaetze.get(platz);
        parkplaetze.set(platz, null); // Platz wieder frei machen
        return verlassendes;
    }

    public double berechneAuslastung() {
        // Formel: (belegte Plätze / Gesamt) * 100
        return 100.0 * (kapazitaet - anzahlFreierPlaetze()) / kapazitaet;
    }

    public int anzahlFreierPlaetze() {
        int freie = 0;
        for (Auto a : parkplaetze) {
            if (a == null) freie++;
        }
        return freie;
    }
}