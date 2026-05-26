package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tanzschule {
    private String name;
    private List<Kurs> kurse;

    // -------------------------- Konstruktoren --------------------
    public Tanzschule(String name) throws TanzschuleException {
        setName(name);
        kurse = new ArrayList<>();
    }

    // ------------------------ getter -----------------------------
    public String getName() {
        return name;
    }

    // -------------------------- setter ----------------------------
    public void setName(String name) throws TanzschuleException {
        if (name != null) this.name = name;
        else {
            throw new TanzschuleException("Fehler bei setName(): null-Referenz fuer name erhalten");
        }
    }
// -------------------------- weitere ---------------------------

    public boolean hinzufuegen(Kurs kurs){
        if (kurs == null || kurse.contains(kurs)) {
            return false;
        }
        return kurse.add(kurs);
    }

    public void sortierenNachPreis() {
        kurse.sort((o1, o2) -> Double.compare(o1.preis(), o2.preis()));
    }

    public void saveKurse() throws TanzschuleException {
        // OOS - ObjectOutputStream -> writeObject(kurse)
        // FOS - FileOutputStream(File)
        // File - File ("saveKurse.ser")
        // Dateiname "saveKurse.ser"
        String pathFileName = "saveKurse.ser";
        File file = new File(pathFileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(kurse);
        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Fehler bei saveKurse() Datei-Problem: " + e.getMessage());
        } catch (IOException e) {
            throw new TanzschuleException("Fehler bei saveKurse() Eingabe/Ausgabe-Problem: " + e.getMessage());
        }
    }

    public void importKurseCsv() throws TanzschuleException {
        String pathFileName = "kurse.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(pathFileName))) {
            String line = br.readLine();
            while (line != null) {
                Kurs kurs = null;
                if (line.startsWith("PrivatKurs")) {
                    try {
                        kurs = new PrivatKurs(line);
                    } catch (TanzschuleException e) {
                        System.out.println("Fehler PrivatKurs mit " + line + " - " + e.getMessage());
                    }
                }
                if (line.startsWith("GruppenKurs")) {
                    try {
                        kurs = new GruppenKurs(line);
                    } catch (TanzschuleException e) {
                        System.out.println("Fehler GruppenKurs mit " + line  + " - " + e.getMessage());
                    }
                }
                if (hinzufuegen(kurs)) {
                    System.out.println("Kurs wurde hinzugefügt: " + kurs);
                } else {
                    System.out.println("Kurs konnte NICHT hinzugefügt werden: " + line);
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Fehler bei importKurseCsv Datei nicht gefunden:  " + pathFileName + ": " + e.getMessage() );
        } catch (IOException e) {
            throw new TanzschuleException("Fehler bei importKurseCsv mit Datei " + pathFileName + ": " + e.getMessage() );
        }
    }

    public void exportPrivatKurseCsv() throws TanzschuleException {
        String pathFileName = "privatKurse.csv";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathFileName))) {
            for(Kurs kurs:kurse) {
                if (kurs instanceof PrivatKurs) {
                    bw.write(kurs.toCsvString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new TanzschuleException("Fehler beim Export mit dem File " + pathFileName + ":" + e.getMessage());
        }
    }

    // --------------------------- toString -----------------------------------

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tanzschule ").append(name).append("\n");
        int anzahl = kurse.size();
        if (anzahl > 0) {
            sb.append("Anzahl der Kurse: ").append(anzahl).append("\n");
            for (int i = 0; i < anzahl; i++)
                sb.append(kurse.get(i).toString()).append("\n");
        } else {
            sb.append("Keine Kurse vorhanden\n");
        }
        return sb.toString();
    }

    public String toCsvString() {
        StringBuilder sb = new StringBuilder();
        for(Kurs kurs : kurse) {
            sb.append(kurs.toCsvString()).append("\n");
        }
        return sb.toString();
    }
}
