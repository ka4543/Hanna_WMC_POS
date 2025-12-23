public class ZahlenProjekt {
    public static void main(String[] args) {
        int[] zahlen = {45, 12, 88, 33, 7, 52, 91, 24, 60, 15};

        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] % 2 == 0) {
                zahlen[i] *= 2;
            } else {
                zahlen[i] -= 10;
            }
        }

        int count = 0;
        for (int z : zahlen) {
            if (z > 50) count++;
        }

        int[] gefiltert = new int[count];
        int index = 0;
        for (int z : zahlen) {
            if (z > 50) {
                gefiltert[index++] = z;
            }
        }

        if (gefiltert.length > 0) {
            int min = gefiltert[0];
            int max = gefiltert[0];

            for (int z : gefiltert) {
                if (z < min) min = z;
                if (z > max) max = z;
            }

            System.out.println("Gefilterte Elemente: " + gefiltert.length);
            System.out.println("Differenz Max-Min: " + (max - min));
        }
    }
}