package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PegelstandTest {

    @Test
    void testAvg() {

        Pegelstand pegelstand = new Pegelstand("Nil", 5);
        pegelstand.fuelleTestwerte();


        assertEquals(292.0f, pegelstand.avgWert(), 0.01f);
    }

    @Test
    void toStringTest() {
        Pegelstand toString = new Pegelstand("Nil", 5);
        toString.toString();
        toString.fuelleTestwerte();


        String ergebnis = toString.toString();
        assertTrue(ergebnis.contains("Nil"), "Der Flussname fehlt im toString!");
        assertTrue(ergebnis.contains("292"), "Der Avg wurde nicht gefunden");
        assertTrue(ergebnis.contains("5"), "Die Anzahl fehlt im toString!");
    }
}
