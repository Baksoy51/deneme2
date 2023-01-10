package tests.day18_htmlReport;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] AmazonAranacakKelimeler() {

        Object[][] amazonAranacakKelimelerArrayi={{"Nutella"},{"Java"},{"Samsung"},{"Armut"}};

        return amazonAranacakKelimelerArrayi;
    }

    @Test(dataProvider = "AmazonAranacakKelimeler")
    public void aramaTesti(String aranacakKelime){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage=new AmazonPage();

        amazonPage.amazonAramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);

        String accuKelieme=amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(accuKelieme.contains(aranacakKelime));


    }
}
