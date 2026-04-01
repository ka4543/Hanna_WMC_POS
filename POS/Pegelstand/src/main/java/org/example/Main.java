package org.example;

public class Main {
   public static void main(String[] args){

       Pegelstand pegelstand = new Pegelstand("Nil",5);

       pegelstand.fuelleTestwerte();
       pegelstand.toString();

       System.out.println(pegelstand.toString());

       Pegelstand pegelstand1 = new Pegelstand("kamel",3);
       pegelstand1.fuelleTestwerte();


       System.out.println(pegelstand1);
   }
}