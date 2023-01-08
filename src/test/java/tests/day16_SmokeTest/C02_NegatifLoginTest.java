package tests.day16_SmokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegatifLoginTest {

    QualitydemyPage qualitydemyPage=new QualitydemyPage();

    @Test

    public void yanlisEmailTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        WebElement cookieKabul = Driver.getDriver().findElement
                (By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
      ;

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Driver.closeDriver();

    }
}
