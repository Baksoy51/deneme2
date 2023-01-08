package tests.day15_SoftAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

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
}
