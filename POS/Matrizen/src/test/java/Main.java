
public class Main {
    public static void main(String[] args) {
        String[] schueler = {"Hanna", "Lukas", "Emma"};
        NotenMatrix m = new NotenMatrix(schueler, 3);


        m.setNote(0, 0, 1);
        m.setNote(0, 1, 2);
        m.setNote(0, 2, 1);

      
        m.setNote(1, 0, 3);
        m.setNote(1, 1, 4);
        m.setNote(1, 2, 2);

        System.out.println(m);

        System.out.println("Durchschnitt Hanna: " + m.getSchnittSchueler(0));
        System.out.println("Durchschnitt Lukas: " + m.getSchnittSchueler(1));
    }
}