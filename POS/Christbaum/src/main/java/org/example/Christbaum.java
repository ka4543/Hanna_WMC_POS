public class Christbaum {
    public static void main(String[] args) {
        int hoehe = 8;

        for (int i = 0; i < hoehe; i++) {
            for (int j = 0; j < hoehe - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (2 * i + 1); k++) {
                if (i == 0) {
                    System.out.print("*");
                } else {
                    System.out.print("^");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < hoehe - 2; j++) {
                System.out.print(" ");
            }
            System.out.println("###");
        }
    }
}