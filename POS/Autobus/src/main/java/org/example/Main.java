#include <LiquidCrystal.h>

// Display-Anschlüsse festlegen
LiquidCrystal lcd(8,9,4,5,6,7) {
    return null;
}

int ldr;
bool ledon;

void setup() {
    Serial.begin(9600);
    lcd.begin(16, 2);    // Startet das Display (16 Zeichen, 2 Zeilen)
    pinMode(13, OUTPUT); // Pin 13 ist für die LED
}

void loop() {
    ldr = analogRead(A1); // Liest den Licht-Wert vom Sensor

    // Wenn es hell ist (Wert > 400), geht die LED an
    if (ldr > 400) {
        digitalWrite(13, HIGH);
        ledon = true;
    } else {
        digitalWrite(13, LOW);
        ledon = false;
    }

    // Infos auf dem Display anzeigen
    lcd.setCursor(0, 0);
    lcd.print("LDR Wert: ");
    lcd.print(ldr);

    lcd.setCursor(0, 1);
    lcd.print("Led Status: ");
    lcd.print(ledon);

    delay(2000); // 2 Sekunden warten
    lcd.clear(); // Display leeren
}