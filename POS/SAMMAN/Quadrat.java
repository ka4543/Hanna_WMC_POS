
/**
 * Beschreiben Sie hier die Klasse quadart.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Quadrat {
    public static void rechteck (int hoehe, int breite) {
        for (int zeile = 0; zeile < hoehe; zeile++) {        
            for (int spalte = 0; spalte < breite; spalte++) {    
                System.out.print(" # ");       
            }
            System.out.println();
        }
    }

    public static void  quadrat (int kante){
        rechteck(kante,kante);}
}
