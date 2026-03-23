package at.spengergasse;

import java.util.ArrayList;
import java.util.List;

public class Notizen {

    private final List<String> notizen;

    //"Brot einkaufen"
    //"Video über Java-Streams ansehen"
    //"Geschenk für Petra besorgen"

    public Notizen() {
        notizen = new ArrayList<>();
    }

    public boolean notizHinzufuegen(String notiz) throws NotizException {
        if (notiz == null || notiz.isBlank()) {
            throw new NotizException("Fehler: null oder leer");
        }
        if (this.notizen.contains(notiz)) {
            return false;
        }
        return notizen.add(notiz);
    }

    public void sortierenAlphabetisch() {
        notizen.sort(null);
    }

    public void sortierenNachLaengeAbsteigend() {
        //Comparator<String> nachLaengeAbsteigendComparator = new LaengeComparator().reversed();
        notizen.sort(new LaengeComparator().reversed());
    }

    public void sortierenNachDerLaengeAufsteigend() {
        notizen.sort(new LaengeComparator());
    }

    public boolean notizEntfernen(String notiz) throws NotizException {
        if (!checkNotiz(notiz)) {
            throw new NotizException("Fehler: notiz ungültig");
        }
        return notizen.remove(notiz);
    }

    private boolean checkNotiz(String notiz) {
        return notiz != null && !notiz.isBlank();
    }

    public void ausgebenNotizen() {
        if (notizen.isEmpty()) {
            System.out.println("Keine Notizen vorhanden");
        }
        System.out.println("Meine Notizen: ");
        for (String notiz : notizen) {
            System.out.println(notiz);
        }
    }
}
