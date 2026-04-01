package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Pegelstand {
    private String fluss = "Donau";
    private int anzahl;
    private int [] werte= new int [7];

    public Pegelstand(String fluss, int anzahl) {
        this.fluss = fluss;
        this.anzahl = anzahl;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public String getFluss() {
        return fluss;
    }

    public void setFluss(String fluss) {
        this.fluss = fluss;
    }
private int Anzahl(){
        if (werte== null || werte.length == 0 ){
            throw new IllegalArgumentException("Ungültige Werte");
         }
        return this.anzahl;
}

private void ausgebenWerte(){
    for (int i = 0; i < werte.length; i++) {
        System.out.println("Werte:" + werte );

    }

}

public void fuelleTestwerte(){
    this.werte[0]= 250;
    this.werte[1]= 290;
    this.werte[2]= 310;
    this.werte[3]= 310;
    this.werte[4]= 300;
    this.werte[5]= 300;
    this.werte[6]= 300;
}

    public float avgWert() {

        if (this.anzahl <= 0) {
            return -99f;
        }

        float summe = 0f;

        for (int i = 0; i < anzahl; i++) {
            summe += werte[i];
        }

        return summe / anzahl;
    }

    private int minWert() {

        if (this.anzahl <= 0) {
            return -99;
        }

        int min = 0;
        for (int i = 0; i < anzahl; i++) {
            min = werte[0];

            if (werte[i] < min) {
                min = werte[i];


            }
        }
        return min;
    }

    private int maxWert(){
        if (anzahl <0){
            return -99;


        }
        int max=0;
        for (int i = 0; i <anzahl ; i++) {

            if (werte[i] >max){
                max=werte[i];

            }

        }
        return max;
    }


    @Override
    public String toString() {
        return "Pegelstand: " +
                "fluss='" + fluss + '\'' +
                ", anzahl=" + anzahl +
                ", werte=" + Arrays.toString(werte)
                + "\nDer durchschnittlicherwert= " + avgWert();
    }
}
