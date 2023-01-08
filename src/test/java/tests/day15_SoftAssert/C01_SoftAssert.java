package tests.day15_SoftAssert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;

public class C01_SoftAssert {
    @Test
    public  void test9(){

        //amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        SoftAssert softAssert=new SoftAssert();
        String expecUrl="amazon";
        String  actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expecUrl));

        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String aramaSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucYazisi.contains("Nutella"));

        amazonPage.amazonAramaKutusu.clear();

        // Java aratın

        amazonPage.amazonAramaKutusu.sendKeys("Java" + Keys.ENTER);
        ReusableMethods.bekle(1);
        System.out.println(amazonPage.aramaSonucuElementi.getText());
        // 1-48 of over 7,000 results for "Java"

        aramaSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        String[] sonucArr=aramaSonucYazisi.split(" ");
        System.out.println(Arrays.toString(sonucArr));

        String javasonucElementi=sonucArr[3];

        javasonucElementi=javasonucElementi.replaceAll("\\W","");
        System.out.println("Sayi hali: " +javasonucElementi);
        //int sonucSayisiInt=Integer.parseInt(javasonucElementi);

      //  softAssert.assertTrue(sonucSayisiInt>1000);

        softAssert.assertTrue(Integer.parseInt(javasonucElementi)>1000,"Java icin 1000 den fazla değil");










        softAssert.assertAll();
        Driver.closeDriver();

    }
}
