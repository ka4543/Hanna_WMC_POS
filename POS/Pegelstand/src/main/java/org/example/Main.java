public class Pegelstand {

    private String fluss = "Donau";
    private int[] werte = new int[7];
    private int anzahl = 0;

    public Pegelstand() {
    }

    public Pegelstand(String fluss) {
        setFluss(fluss);
    }

    public int getAnzahl() {
        return this.anzahl;
    }

    public String getFluss() {
        return fluss;
    }

    public void setFluss(String fluss) {
        if (fluss != null && !fluss.isEmpty()) {
            this.fluss = fluss;
        }
    }

    public int getWert(int index) {
        if (index >= 0 && index < anzahl) {
            return werte[index];
        }
        return -99;
    }

    public boolean messen(int wert) {
        if (wert < 0 || anzahl >= werte.length) {
            return false;
        }
        werte[anzahl] = wert;
        anzahl++;
        return true;
    }

    public void fuelleTestwerte() {
        werte[0] = 250;
        werte[1] = 290;
        werte[2] = 310;
        werte[3] = 310;
        werte[4] = 300;
        werte[5] = 300;
        werte[6] = 300;
        anzahl = 7;
    }

    public float avgWert() {
        if (anzahl <= 0) return -99f;
        float summe = 0;
        for (int i = 0; i < anzahl; i++) {
            summe += werte[i];
        }
        return summe / anzahl;
    }

    public int minWert() {
        if (anzahl <= 0) return -99;
        int min = werte[0];
        for (int i = 1; i < anzahl; i++) {
            if (werte[i] < min) {
                min = werte[i];
            }
        }
        return min;
    }

    public int maxWertIndex() {
        if (anzahl <= 0) return -99;
        int index = 0;
        for (int i = 1; i < anzahl; i++) {
            if (werte[i] > werte[index]) {
                index = i;
            }
        }
        return index;
    }

    public void printHoehenprofil() {
        for (int i = 0; i < anzahl; i++) {
            System.out.print("[" + i + "]: ");
            for (int j = 0; j < werte[i] / 10; j++) {
                System.out.print("~");
            }
            System.out.println(" (" + werte[i] + " cm)");
        }
    }

    public void ausgebenWerte() {
        for (int i = 0; i < werte.length; i++) {
            System.out.println("Index " + i + ": " + werte[i]);
        }
    }

    public void printPegelstand() {
        System.out.println("Fluss: " + fluss);
        System.out.println("Anzahl: " + anzahl);
        for (int i = 0; i < anzahl; i++) {
            System.out.println("Messwert " + (i + 1) + ": " + werte[i]);
        }
    }

    @Override
    public String toString() {
        return "Fluss: " + fluss + ", Anzahl: " + anzahl + ", Werte: " + java.util.Arrays.toString(werte);
    }
}