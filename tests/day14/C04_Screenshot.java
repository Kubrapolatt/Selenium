package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {

    @Test
    public void test01(){
        driver.get("https://google.com");

        // 1.adım : screenshot almak için obje oluşturalım ve değer olarak driver'ımızı atayalım
        //          değer olarak driver'ı kabul etmesi için casting yapmamız gerekir

        TakesScreenshot tss=(TakesScreenshot)driver;

        // 2.adım : tüm sayfanın screenshot'ını almak için bir File oluşturalım ve dosya yolunu belirtelim

        File tumSayfaScreenshot=new File("src//tumSayfa.png");

        // 3.adım : : oluşturduğumuz file ile takesreenshot objesn ilişkilendirelim

        tumSayfaScreenshot=tss.getScreenshotAs(OutputType.FILE);

        // eğer spesifik webelemenin screenshotun'ını almak istiyorsanız

        WebElement logoElementi= driver.findElement(By.xpath("//img[@alt='Google']"));

        File logoResmi=new File("src/logo.png");






    }


}
