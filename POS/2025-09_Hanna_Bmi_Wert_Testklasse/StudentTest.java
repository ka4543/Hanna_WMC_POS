

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest
    {
        private Student Anna;
        private Student Lara;
        private Student Nicole;
        
        private Student Kamel;
        private Student Alex;
        private Student Marko;

    
    @BeforeEach
    public void setUp()
    {
        System.out.println("SetUp");
        Anna= new Student("Anna",50,180,'F');
        Lara= new Student("Lara",70,150,'F');
        Nicole= new Student("Nicole",50,150,'F');
        
        Kamel= new Student("Kamel",90,170,'m');
        Alex= new Student("Alex",70,190,'m');
        Marko= new Student("Marko",75,180,'m');
    }
    
    @Test
    public void TestAnna(){
    assertEquals("Untergewicht", Anna.BmiKlasse(),"BMI von Anna");
}
@Test
    public void TestLara(){
        assertEquals("Übergewicht", Lara.BmiKlasse());
}
@Test
    public void TestNicole(){
        assertEquals("Normalgewicht", Nicole.BmiKlasse());
}
@Test
    public void TestKamel(){
        assertEquals("Übergewicht", Kamel.BmiKlasse());
}
@Test
    public void TestAlex(){
        assertEquals("Untergewicht", Alex.BmiKlasse());
}
@Test
    public void TestMarko(){
        assertEquals("Normalgewicht", Marko.BmiKlasse());
}
@Test
    public void TestAnnaFloat(){
        assertEquals(15.43, Anna.bmi(),0.1,"BMI von ANNA");
}
@Test
    public void TestLaraFloat(){
        assertEquals(31.11, Lara.bmi(),0.1,"BMI von LARA");
    }
        @Test
    public void TestNicoleFloat(){
        assertEquals(22.22, Nicole.bmi(),0.1,"BMI von Nicole");
}
@Test
     public void TestKonstruktor(){
      assertThrows(IllegalArgumentException.class, () -> {
       new Student("Kamel", 80, 49,'m');
        }, "Grösse muss zwi. 50-250 cm sein");
    }
    
    
    @AfterEach
    public void tearDown()
    {
        System.out.println("tearDown");
    }
}