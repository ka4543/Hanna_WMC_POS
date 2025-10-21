/**
 * Beschreiben Sie hier die Klasse Kamel.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kamel {
    public static void kamel() {
        // Das Muster von "KAMEL" aus # - jede Zeile ist ein String
        String[] muster = {
            "##    ##     ###      ### ###  ########  ##       ",
            "##   ##     ## ##    #### ###  ##        ##       ",
            "##  ##     ##   ##   ## # # ##  ##        ##       ",
            "#####     #########  ##  #  ##  ######    ##       ",
            "##  ##    ##     ##  ##     ##  ##        ##       ",
            "##   ##   ##     ##  ##     ###  ##        ##       ",
            "##    ##  ##     ##  ##     ##   ########  ######## "
        };

        // Äußere Schleife: Zeilen
        for (int zeile = 0; zeile < muster.length; zeile++) {
            // Innere Schleife: Zeichen pro Zeile
            for (int spalte = 0; spalte < muster[zeile].length(); spalte++) {
                char zeichen = muster[zeile].charAt(spalte);

                // Wenn ein # im Muster steht, wird er ausgegeben
                if (zeichen == '#') {
                    System.out.print("#");
                } else {
                    // Leerzeichen beibehalten
                    System.out.print(" ");
                }
            }
            System.out.println(); // Zeilenumbruch
        }
    }
    
    public static void main(String[] args) {
        kamel();
    }
}
