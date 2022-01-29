package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

//Yeni bir class olusturalim: D15_MouseActions4
public class C06_FacebookKayıt extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim
        WebElement adElementi=driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
        Actions actions=new Actions(driver);
        actions.click(adElementi).perform();

        actions.keyDown(Keys.SHIFT).sendKeys("k").keyUp(Keys.SHIFT).sendKeys("übra").perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).keyDown(Keys.SHIFT).sendKeys("p").keyUp(Keys.SHIFT).sendKeys("olat").perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).keyDown(Keys.SHIFT).sendKeys("u").keyUp(Keys.SHIFT).sendKeys("nicornseverlerderneği@gmail.com").perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).keyDown(Keys.SHIFT).sendKeys("u").keyUp(Keys.SHIFT).sendKeys("nicornseverlerderneği@gmail.com").perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).sendKeys("tekboynuzluat").perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("19").perform();
        actions.sendKeys(Keys.TAB).sendKeys("Ara").perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).sendKeys("1999").perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
        Thread.sleep(1000);

        //4- Kaydol tusuna basalim
        WebElement kaydolButonu= driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _6o _6v']"));

        actions.click(kaydolButonu).perform();


    }


}
