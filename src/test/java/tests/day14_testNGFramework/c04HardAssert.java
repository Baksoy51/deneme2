package tests.day14_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class c04HardAssert {

    //testNG de 2 tane Assert class ı var
    // 1. JUnit deki ile ayni ozellige sahip, ilk faiden sonra çalışmayı durdurur hata mesajı verir
    // 2.Asset class ise SoftAssert classidir. raporla deyinceye kadar calisir.
    // raporla deyince calismayi durdurur

    @Test
    public void test44(){

        Assert.assertTrue(6>4);
        System.out.println("1.assertion sonrasi");
        Assert.assertTrue(6>14);
        System.out.println("2.assertion sonrasi");
        Assert.assertEquals(6,6);
        System.out.println("3.assertion sonrasi");
    }
}
