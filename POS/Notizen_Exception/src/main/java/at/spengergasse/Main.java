package at.spengergasse;


public class Main {
    static void main() {
        try {
            Notizen notizen = new Notizen();
            notizen.ausgebenNotizen();
            System.out.println();

            System.out.println(notizen.notizHinzufuegen("Brot einkaufen"));
            System.out.println(notizen.notizHinzufuegen("Brot einkaufen"));
            System.out.println(notizen.notizHinzufuegen("Anna anrufen"));
            System.out.println(notizen.notizHinzufuegen("Film Van Damme streamen"));
            System.out.println(notizen.notizHinzufuegen("Chips einkaufen"));
            System.out.println(notizen.notizHinzufuegen("Ins Gym gehen"));

            notizen.ausgebenNotizen();
            System.out.println();

            notizen.sortierenAlphabetisch();
            notizen.ausgebenNotizen();
            System.out.println();

            System.out.println(notizen.notizEntfernen("Ins Gym gehen"));
            notizen.ausgebenNotizen();
            System.out.println();

            notizen.sortierenNachLaengeAbsteigend();
            notizen.ausgebenNotizen();
            System.out.println();

            notizen.notizHinzufuegen("Perl lernen");
            notizen.notizHinzufuegen("Java lernen");
            notizen.ausgebenNotizen();
            System.out.println();

            notizen.sortierenAlphabetisch();
            notizen.ausgebenNotizen();
            System.out.println();

            notizen.sortierenNachDerLaengeAufsteigend();
            notizen.ausgebenNotizen();
            System.out.println();

            notizen.notizHinzufuegen("Zumba lernen");
            notizen.notizHinzufuegen("AM lernen");
            notizen.ausgebenNotizen();
            System.out.println();

            notizen.sortierenNachDerLaengeAufsteigend();
            notizen.ausgebenNotizen();
            System.out.println();
        } catch (NotizException e) {
            System.out.println("FEHLER: unerwartete Exception: " + e.getMessage());
            //System.exit(0);  // NOOOOOOOOO GOOOOOOOOOOOOOOOOOOOOOOOOOO!!!!!!
        }
//        finally {
//            System.out.println("Dieser Codeblock wird IMMER ausgeführt");
//        }
    }
}
