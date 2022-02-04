package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenshotWebElement extends TestBase {

    @Test
    public void nutellaTesti() throws IOException {

        //Amazon ana sayfaya gidelim
        driver.get("https://www.amazon.com");
        // nutela için arama yapalım
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        //sonuçların nutella içerdiğini test edelim
        WebElement sonuçYazısıElementi= driver.findElement(By.xpath("//div[@class='sg-col-inner']"));

        String sonuçSayısıStr= sonuçYazısıElementi.getText();

        Assert.assertTrue(sonuçSayısıStr.contains("Nutella"));

        //testin çalıştığının ispatı için sonuç yazısı elementinin screenshot'ını alalım
        //1.adım : screenshot çekeceğimiz webelementi locate edelim

        //2.adım : scrshot'ı kaydedeceğimiz bir file oluşturalım
        File webElementSS=new File("target/screenshot/webelement.jpeg");

        //3.adım :
        File geçiciResim=sonuçYazısıElementi.getScreenshotAs(OutputType.FILE);

        //4.adım : geçici resmi kayıt yapacağımız asıl dosyaya kopyalayalım
        FileUtils.copyFile(geçiciResim,webElementSS);

    }
}





