package tests.day16_SmokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PozitifLoginTest {

    @Test
    public void pozitifLogonTest(){


        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();


        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

       // qualitydemyPage.cookiesAccept.click();

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.basariliGirisCourseLinki.isDisplayed());

        ReusableMethods.bekle(1);
        Driver.closeDriver();
    }
}
