package tests.day18_htmlReport;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderNegativeLoginTesti {

    @DataProvider
    public static Object[][] kullaniciBilgileri() {

        Object[][] kullaniciBilgileriArrayi={{"as","hgfjh"},{"asas","cklcj"},{"sa","yuy"}};

        return kullaniciBilgileriArrayi;
    }

    @Test(dataProvider = "kullaniciBilgileri")

    public void negativeLoginTest(String username, String password){

    Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

    QualitydemyPage qualitydemyPage=new QualitydemyPage();
    qualitydemyPage.ilkLoginLinki.click();

    qualitydemyPage.kullaniciEmailKutusu.sendKeys(username);
    qualitydemyPage.passwordKutusu.sendKeys(password);
    qualitydemyPage.loginButonu.click();

    Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());


 }
}
