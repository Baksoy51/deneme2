package tests.day14_testNGFramework;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C05_SoftAssert {

    @Test(groups = "minireg1")
    public void test33(){

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(6,8);
        System.out.println("1.Assertion sonrasi");
        softAssert.assertTrue(5>3);
        System.out.println("2. sonrasi");

        softAssert.assertFalse(8>5);
        System.out.println("3.sonrasi");

        softAssert.assertAll();

        System.out.println("assertAll sonrasi");

        //bundan sonrasini gormez,calisma durur
    }
}
