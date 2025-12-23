public class LagerVerwaltung {
    public static void main(String[] args) {
        String[] produkte = {"Laptop", "Maus", "Tastatur", "Monitor", "Kabel"};
        double[] preise = {999.99, 25.50, 49.90, 199.00, 12.00};
        int[] bestand = {10, 2, 15, 4, 20};

        double gesamtwert = 0;
        int maxIndex = 0;
        int knappCount = 0;

        for (int i = 0; i < produkte.length; i++) {
            gesamtwert += preise[i] * bestand[i];

            if (preise[i] > preise[maxIndex]) {
                maxIndex = i;
            }

            if (bestand[i] < 5) {
                knappCount++;
            }
        }

        String[] kritischerBestand = new String[knappCount];
        int j = 0;
        for (int i = 0; i < produkte.length; i++) {
            if (bestand[i] < 5) {
                kritischerBestand[j] = produkte[i];
                j++;
            }
        }

        System.out.println("Gesamtwert Lager: " + gesamtwert);
        System.out.println("Teuerstes Produkt: " + produkte[maxIndex]);
        System.out.print("Nachbestellen: ");
        for (String p : kritischerBestand) {
            System.out.print(p + " ");
        }
    }
}