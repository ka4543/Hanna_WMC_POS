public class Student {

    private String vorname;   // Name Student 

    private float kg;      // Gewicht in Kilogramm kommaZahl    
    private int cm;        // Größe in Zentimeter GanzZahl
    private char gender;   // Geschlecht

    public Student(String vorname, float kg, int cm, char gender) {
        this.setName(vorname);       // Namen  speichern
        this.setKg(kg);           // Gewicht  speichern
        this.setCm(cm);           // Größe  speichern
        this.setGender(gender);   // Geschlecht  speichern
    }

    public void setName (String vorname){
        if( vorname.length()< 3 || vorname.length() >50 ){
            throw new IllegalArgumentException("Name muss zwi. 3-50 Buchstaben sein! Grossbuchstaben möglich.");
        }
        this.vorname=vorname;
    }

    public void setKg(float kg){
        if(kg < 2f || kg > 550f){
            throw new IllegalArgumentException("Masse muss zwi. 2-550 sein");
        }
        this.kg=kg;
    }

    public void setCm(int cm){
        if(cm <50 || cm > 230){
            throw new IllegalArgumentException("Groesse muss zwi. 50- 230 sein");
        }
        this.cm=cm;
        System.out.println ("Deine Groessse beträgt " + this.cm +" cm") ;

    }

    public void setGender(char genderCase) {
        genderCase= Character.toLowerCase(genderCase);
        if( genderCase != 'm' && genderCase !='f'){
            throw new IllegalArgumentException("Gender muss M oder F sein");
        }

        this.gender = genderCase;
    }

    public float bmi() {
        float meter = this.cm / 100.0f;
        return this.kg / (meter * meter);
    }

    public String mannOderFrau() {
        // wir vergleichen den Buchstaben
        if (this.gender == 'm' )
            return "männlich";  
        if (this.gender == 'f' ) 
            return "weiblich"; 

        return "Bitte gültige Daten eingeben!";
    }

    public String BmiKlasse() {
        float bmi = this.bmi();  // BMI berechnen

        // Männer 
        if (this.gender == 'm' || this.gender == 'M') {
            if (bmi < 20f) return "Untergewicht";      // 
            else if (bmi <= 25f) return "Normalgewicht"; // 
            else return "Übergewicht";                  // 
        }
        // Frauen
        else if (this.gender == 'f' || this.gender == 'F') {
            if (bmi < 19f) return "Untergewicht";      
            else if (bmi <= 24f) return "Normalgewicht"; 
            else return "Übergewicht";                  
        }
        else {
            return "Fehler: kein gültiges Geschlecht";
        }
    }

    public String printStudent() {
        return "Name: " + this.vorname
        + " (" + this.mannOderFrau() + "), "
        + this.kg + "kg, "
        + this.cm + "cm ("
        + this.BmiKlasse() + ")";
    }
}