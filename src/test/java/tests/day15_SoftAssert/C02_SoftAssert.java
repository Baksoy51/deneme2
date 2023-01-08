package tests.day15_SoftAssert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C02_SoftAssert {

    @Test
    public void test04(){


        // “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");
        // . Sign in butonuna basin

        ZeroWebAppPage zeroWebAppPage=new ZeroWebAppPage();
        zeroWebAppPage.signInButonu.click();

        // . Login kutusuna “username” yazin
        zeroWebAppPage.userNameKutusu.sendKeys("username");
        // . Password kutusuna “password” yazin
        zeroWebAppPage.passWordKutusu.sendKeys("password");
        // . Sign in tusuna basin
        zeroWebAppPage.signInSubmitButonu.click();
        // . Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().navigate().back();
        zeroWebAppPage.onlineBanking.click();
        zeroWebAppPage.payBillLinki.click();

        // . “Purchase Foreign Currency” tusuna basin
           zeroWebAppPage.purchaseFCButonu.click();

        // . “Currency” drop down menusunden Eurozone’u secin

        Select select=new Select(zeroWebAppPage.currencyDropdown);
        select.selectByVisibleText("Eurozone (euro)");
        // . soft assert kullanarak “Eurozone (euro)” secildigini test edin

        SoftAssert softAssert=new SoftAssert();
        String actualDropSecim=select.getFirstSelectedOption().getText();
        String expectedDropSecim="Eurozone (euro)";

        softAssert.assertEquals(actualDropSecim,expectedDropSecim,"Eurozon testi");

        // 0. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        // edin “Select One”, “Australia (dollar)“, “Canada (dollar)“,”Switzerland (franc)“,”China (yuan)“
        // ,”Denmark (krone)“,”Eurozone (euro)“,”Great Britain (pound)“,”Hong Kong (dollar)“,”Japan (yen)“,
        // ”Mexico (peso)“,”Norway (krone)“,”New Zealand (dollar)“,”Sweden (krona)“,”Singapore (dollar)“,
        // ”Thailand (baht)”

        List<WebElement> optionsElementList=select.getOptions();
        List<String > actualOptionsListStr=new ArrayList<>();

        for (WebElement each1: optionsElementList
             ) {
            actualOptionsListStr.add(each1.getText());
        }
        String[] arr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedOptionsListesi= Arrays.asList(arr);

        Collections.sort(actualOptionsListStr);
        Collections.sort(expectedOptionsListesi);

        softAssert.assertEquals(actualOptionsListStr,expectedOptionsListesi);

        ReusableMethods.bekle(3);
        softAssert.assertAll();
        Driver.closeDriver();

    }
}
