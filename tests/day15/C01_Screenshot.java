package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_Screenshot extends TestBase {

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

        //testin çalıştığının ispatı için tüm sayfanın screenshot'ını alalım
        //tüm sayfa screenshot için 4 adım gerekli

        //1.adım : TakesScreenshot objesi oluşturmak
        TakesScreenshot tss=(TakesScreenshot)driver;

        //2.adım : kaydedeceğimiz dosyayı oluşturalım
        File tümSayfaScreenshot=new File("target/screenshot/tümsayfa.png");

        //3.adım : bir dosya daha oluşturup screenshot objesi ile screenshot'ı alalım
        File geçiciResim=tss.getScreenshotAs(OutputType.FILE);

        //4.adım : geçici resmi kaydetmek istediğimiz asıl dosyaya copy yapalım
        FileUtils.copyFile(geçiciResim,tümSayfaScreenshot);

    }


}
