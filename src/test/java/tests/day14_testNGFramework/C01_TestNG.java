package tests.day14_testNGFramework;

import org.testng.annotations.Test;

public class C01_TestNG {
    @Test ( priority = 6)

    public void ilkTest(){
        System.out.println("ilk test calisti");

     }
    @Test
     public void ikinciTest(){
         System.out.println("ikinci test calisti");

     }
     @Test ( priority = -9)
     public void ucuncuTest(){
         System.out.println("ucuncu test calisti");


     }


}
