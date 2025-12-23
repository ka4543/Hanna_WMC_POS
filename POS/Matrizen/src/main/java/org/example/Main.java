package at.spengergasse;

public class NotenMatrix {
    private String[] namen;
    private int[][] noten;

    public NotenMatrix(String[] namen, int anzahlFaecher) {
        this.namen = namen;
        this.noten = new int[namen.length][anzahlFaecher];
    }

    public void setNote(int schuelerIndex, int fachIndex, int note) {
        if (schuelerIndex >= 0 && schuelerIndex < noten.length &&
                fachIndex >= 0 && fachIndex < noten[0].length) {
            noten[schuelerIndex][fachIndex] = note;
        }
    }

    public double getSchnittSchueler(int schuelerIndex) {
        double summe = 0;
        for (int note : noten[schuelerIndex]) {
            summe += note;
        }
        return summe / noten[schuelerIndex].length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Notenspiegel:\n");
        for (int i = 0; i < noten.length; i++) {
            sb.append(String.format("%-10s: ", namen[i]));
            for (int j = 0; j < noten[i].length; j++) {
                sb.append(noten[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}