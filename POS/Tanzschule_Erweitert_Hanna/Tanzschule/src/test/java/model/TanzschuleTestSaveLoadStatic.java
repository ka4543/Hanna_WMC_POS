package model;

public class TanzschuleTestSaveLoadStatic {

    public static void main(String[] args) {
        testSaveKurse(); // 3 Kurse
        testPrivatKurseCsv();
        testImportKurseCsv();
        //testLoadKurse(); // 3 Kurse
    }

    private static void testImportKurseCsv() {
        try {
        // GIVEN
        Tanzschule tanzschule = new Tanzschule("Dorn");
        System.out.println(tanzschule);
            System.out.println();
        // WHEN THEN

            tanzschule.importKurseCsv();
            System.out.println("Kurse wurden geladen");
            System.out.println(tanzschule);
            System.out.println();

        } catch (TanzschuleException e) {
            System.out.println("Exception bei testPrivatKurseCsv(): " + e.getMessage());
        }
    }

    private static void testPrivatKurseCsv() {
        try {
            // GIVEN
            Tanzschule tanzschule = new Tanzschule("Dorn");
            GruppenKurs gruppenKurs = new GruppenKurs(5, 40f);
            GruppenKurs gruppenKurs1 = new GruppenKurs(3, 30f);
            PrivatKurs privatKurs = new PrivatKurs(1, 100f);
            tanzschule.hinzufuegen(gruppenKurs);
            tanzschule.hinzufuegen(gruppenKurs1);
            tanzschule.hinzufuegen(privatKurs);
            // WHEN
            tanzschule.exportPrivatKurseCsv();
            System.out.println("Die PrivatKurse wurden gespeichert");
            // sollte in der GUI angezeigt
            // THEN
            // Kurse gespeichert..
        } catch (TanzschuleException e) {
            System.out.println("Exception bei testPrivatKurseCsv(): " + e.getMessage());
        }
    }

    private static void testSaveKurse() {
        try {
            // GIVEN
            Tanzschule tanzschule = new Tanzschule("Dorn");
            GruppenKurs gruppenKurs = new GruppenKurs(5, 40f);
            GruppenKurs gruppenKurs1 = new GruppenKurs(3, 30f);
            PrivatKurs privatKurs = new PrivatKurs(1, 100f);
            tanzschule.hinzufuegen(gruppenKurs);
            tanzschule.hinzufuegen(gruppenKurs1);
            tanzschule.hinzufuegen(privatKurs);
            // WHEN
            tanzschule.saveKurse();
            System.out.println("Die Kurse wurden gespeichert");
            // sollte in der GUI angezeigt
            // THEN
            // Kurse gespeichert..
        } catch (TanzschuleException e) {
            System.out.println("Exception bei testLoadKurse(): " + e.getMessage());
        }
    }


//    private static void testLoadKurse() {
//        try {
//            // GIVEN leere Tanzschule
//            Tanzschule tanzschule = new Tanzschule("Dorn");
//            System.out.println(tanzschule); // 0 Kurse
//
//            // WHEN
//            tanzschule.loadKurse();
//            System.out.println("Kurse wurden geladen");
//
//            // THEN einen Kurs in die Tanzschule hereingeladen
//            System.out.println(tanzschule); // 3
//
//        } catch (TanzschuleException e) {
//            System.out.println("Exception bei testLoadKurse(): " + e.getMessage());
//        }
//    }
}
