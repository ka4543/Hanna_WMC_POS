public class torte {
    public static void torte(String[] args) {
        int stockwerke = 3;
        int basisBreite = 10;

        for (int i = 0; i < stockwerke; i++) {
            int aktuelleBreite = basisBreite + (i * 4);
            int leerzeichen = ( (basisBreite + (stockwerke - 1) * 4) - aktuelleBreite) / 2;

            for (int h = 0; h < 2; h++) {
                for (int s = 0; s < leerzeichen; s++) {
                    System.out.print(" ");
                }
                for (int b = 0; b < aktuelleBreite; b++) {
                    if (h == 0) {
                        System.out.print("~");
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
        }
    }
}