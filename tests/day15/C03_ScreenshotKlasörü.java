package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenshotKlasörü extends TestBase {

    //amazona gidin
    //3 farklı test methodu ile java,nutella,elma aratın
    //sonuç sayfasının screenshot'ını kaydedin

    WebElement aramaKutusu;
    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");
        aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);
        tümSayfaScreenShot();
    }

    @Test
    public void test02() throws IOException {
        aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        tümSayfaScreenShot();
    }

    @Test
    public void test03() throws IOException {
        aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Elma", Keys.ENTER);
        tümSayfaScreenShot();
    }

}
