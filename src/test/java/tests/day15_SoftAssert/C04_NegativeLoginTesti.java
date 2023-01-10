package tests.day15_SoftAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NegativeLoginTesti {
    QualitydemyPage qualitydemyPage=new QualitydemyPage();

    @Test
    public void negativeEmailTest(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        WebElement cookieKabul = Driver.getDriver().findElement
                (By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("mehmt@abc.com");
        qualitydemyPage.passwordKutusu.sendKeys("31488081");
        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());

        Driver.closeDriver();
    }



    @Test
    public void yanlisPassword(){
        qualitydemyPage=new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.loginButonu.click();
        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        ReusableMethods.bekle(30);
        Driver.closeDriver();
    }
    @Test
    public void yanlisUsernameYanlisPasswordTesti(){
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qbGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.loginButonu.click();
        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        ReusableMethods.bekle(30);
        Driver.closeDriver();
    }
}
