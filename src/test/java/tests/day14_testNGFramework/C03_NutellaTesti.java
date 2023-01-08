package tests.day14_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C03_NutellaTesti {

    @Test(groups = "minireg1")
    public void test01(){

        Driver.getDriver().get("https://www.amazon.com/");

        //nutella için arama yap

      // WebElement aramaKutusu= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        AmazonPage amazonPage=new AmazonPage();
       amazonPage.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

       //  WebElement aramaSonucuElement=Driver.getDriver().findElement
            //   (By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
       String ecKelim="Nutella";
       String actKelime=amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actKelime.contains(ecKelim));


     Driver.closeDriver();

    }
}
