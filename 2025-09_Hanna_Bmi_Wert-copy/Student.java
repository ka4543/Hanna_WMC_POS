public class Student {

    // ===========================
    // 1) Attribute (Datenfelder)
    // ===========================
    // Das sind die Informationen, die jeder Student hat
    private String name;   // Name des Studenten (Text)
    private float kg;      // Gewicht in Kilogramm (Dezimalzahl)
    private int cm;        // Größe in Zentimeter (ganze Zahl)
    private char gender;   // Geschlecht: 'm' für männlich, 'w' für weiblich

    // =========================================
    // 2) Konstruktor
    // =========================================
    // Der Konstruktor wird aufgerufen, wenn wir ein neues Student-Objekt erstellen.
    // Er setzt direkt die Anfangswerte für Name, Gewicht, Größe und Geschlecht
    public Student(String name, float kg, int cm, char gender) {
        this.setName(name);       // ruft die Methode setName auf, um den Namen zu speichern
        this.setKg(kg);           // ruft die Methode setKg auf, um das Gewicht zu speichern
        this.setCm(cm);           // ruft die Methode setCm auf, um die Größe zu speichern
        this.setGender(gender);   // ruft die Methode setGender auf, um das Geschlecht zu speichern
    }

    // =========================================
    // 3) Setter-Methoden
    // =========================================
    // Setter werden benutzt, um die Werte der Attribute zu ändern

    // Name setzen
    public void setName(String name) {
        // "this.name" bedeutet: das Attribut name dieses Objekts
        // wird gleich dem Parameter "name" gesetzt
        this.name = name;
    }

    // Gewicht setzen
    public void setKg(float kg) {
        this.kg = kg;
    }

    // Größe setzen
    public void setCm(int cm) {
        this.cm = cm;
    }

    // Geschlecht setzen
    public void setGender(char gender) {
        this.gender = gender;
    }

    // =========================================
    // 4) BMI berechnen
    // =========================================
    // BMI = Körpergewicht / (Körpergröße in Metern)^2
    public float bmi() {
        // cm / 100.0f -> wir wandeln cm in Meter um (z.B. 180cm -> 1,8m)
        // f hinter 100.0f sagt Java, dass es eine float-Zahl ist
        float meter = this.cm / 100.0f;
        return this.kg / (meter * meter);
    }

    // =========================================
    // 5) Geschlecht als Text zurückgeben
    // =========================================
    public String mannOderFrau() {
        // wir vergleichen den Buchstaben
        if (this.gender == 'm' || this.gender == 'M') return "männlich";  // m oder M = männlich
        if (this.gender == 'w' || this.gender == 'W') return "weiblich";  // w oder W = weiblich

        // falls jemand etwas anderes eingibt (sollte nicht vorkommen)
        return "Fehler: kein gültiges Geschlecht";
    }

    // =========================================
    // 6) Gewichtsklasse bestimmen
    // =========================================
    // Untergewicht, Normalgewicht oder Übergewicht
    // Unterschiedliche Grenzen für Männer und Frauen
    public String gewichtsklasse() {
        float bmi = this.bmi();  // BMI berechnen

        // Männer 
        if (this.gender == 'm' || this.gender == 'M') {
            if (bmi < 20f) return "Untergewicht";      // BMI < 20 → Untergewicht
            else if (bmi <= 25f) return "Normalgewicht"; // BMI 20–25 → Normal
            else return "Übergewicht";                  // BMI > 25 → Übergewicht
        }
        // Frauen
        else if (this.gender == 'w' || this.gender == 'W') {
            if (bmi < 19f) return "Untergewicht";      // BMI < 19 → Untergewicht
            else if (bmi <= 24f) return "Normalgewicht"; // BMI 19–24 → Normal
            else return "Übergewicht";                  // BMI > 24 → Übergewicht
        }
        // Ungültiges Geschlecht (kann theoretisch nicht vorkommen)
        else {
            return "Fehler: kein gültiges Geschlecht";
        }
    }

    // =========================================
    // 7) Alle Studentendaten als Text zurückgeben
    // =========================================
    // Das ist praktisch, um in BlueJ oder in der Konsole alles auf einmal auszugeben
    public String printStudent() {
        // Name + Geschlecht + Gewicht + Größe + Gewichtsklasse
        return "Name: " + this.name
            + " (" + this.mannOderFrau() + "), "
            + this.kg + "kg, "
            + this.cm + "cm ("
            + this.gewichtsklasse() + ")";
    }
}