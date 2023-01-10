package tests.day18_htmlReport;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.ObjectInputFilter;

public class C01_HTML_Reports extends TestBaseRapor {

    @Test
    public void test11(){

        extentTest=extentReports.createTest("nutella testi","amazonda arandi");

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("" +
                "Nutella" + Keys.ENTER);

        String actulKelime=amazonPage.aramaSonucuElementi.getText();
        String expectKelime="Nutella";

        Assert.assertTrue(actulKelime.contains(expectKelime));
    }

}
