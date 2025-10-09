public class FizzAufgabe {
    public static void main(String[] args) {
        for (int zahl = 1; zahl <= 100; zahl++) {
            if (zahl % 3 == 0 && zahl % 5 == 0 ) {
                System.out.println("FizzBuzz"); 
            }
                else if (zahl % 3 == 0 && zahl % 7 == 0 ) {
                    System.out.println("FizzWhizz"); 
                }
                else if (zahl % 3 == 0) {
                    System.out.println("Fizz"); 
                }  
                else if (zahl % 5 == 0) {
                    System.out.println("Buzz"); 
                } 
                else if (zahl % 7 == 0) {
                    System.out.println("Whizz"); 
                }else {
                    System.out.println(zahl); 
                }
            }
        }
    }

