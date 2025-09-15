public class Student {

    private String name;   // Name Student 
    private float kg;      // Gewicht in Kilogramm kommaZahl
    private int cm;        // Größe in Zentimeter GanzZahl
    private char gender;   // Geschlecht

    public Student(String name, float kg, int cm, char gender) {
        this.setName(name);       // Namen  speichern
        this.setKg(kg);           // Gewicht  speichern
        this.setCm(cm);           // Größe  speichern
        this.setGender(gender);   // Geschlecht  speichern
    }

    public void setName(String name) {
        this.name = name;
    }

  
    public void setKg(float kg) {
        this.kg = kg;
    }

    
    public void setCm(int cm) {
        this.cm = cm;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public float bmi() {
        float meter = this.cm / 100.0f;
        return this.kg / (meter * meter);
    }

    public String mannOderFrau() {
        // wir vergleichen den Buchstaben
        if (this.gender == 'm' || this.gender == 'M') return "männlich";  
        if (this.gender == 'w' || this.gender == 'W') return "weiblich";  

        return "Bitte gültige Daten eingeben!";
    }

    public String gewichtsklasse() {
        float bmi = this.bmi();  // BMI berechnen

        // Männer 
        if (this.gender == 'm' || this.gender == 'M') {
            if (bmi < 20f) return "Untergewicht";      // 
            else if (bmi <= 25f) return "Normalgewicht"; // 
            else return "Übergewicht";                  // 
        }
        // Frauen
        else if (this.gender == 'w' || this.gender == 'W') {
            if (bmi < 19f) return "Untergewicht";      
            else if (bmi <= 24f) return "Normalgewicht"; 
            else return "Übergewicht";                  
        }
        else {
            return "Fehler: kein gültiges Geschlecht";
        }
    }

    public String printStudent() {
        return "Name: " + this.name
            + " (" + this.mannOderFrau() + "), "
            + this.kg + "kg, "
            + this.cm + "cm ("
            + this.gewichtsklasse() + ")";
    }
}