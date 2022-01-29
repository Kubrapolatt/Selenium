package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

//  1- Yeni bir class olusturalim: MouseActions1

public class C03_MouseActions1 extends TestBase {

    @Test
    public void mouseActionsTest() throws InterruptedException {
        //  2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //  3- Cizili alan uzerinde sag click yapalim

        WebElement çiziliAlanElementi=driver.findElement(By.id("hot-spot"));

        Actions actions=new Actions(driver);
        actions.contextClick(çiziliAlanElementi).perform();

        //  4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.

        String expectedYazı="You selected a context menu";
        String actualYazı=driver.switchTo().alert().getText();

        Assert.assertEquals(actualYazı,expectedYazı);

        //  5- Tamam diyerek alert’I kapatalim

        driver.switchTo().alert().accept();

        //  6- Elemental Selenium linkine tiklayalim

        String windowHandleDeğeriİlkSayfa= driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        //  7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        String windowHandleDeğeriİkinciSayfa="";

        Set<String> handleSet=driver.getWindowHandles();

        for (String each:handleSet
             ) {
            if (!each.equals(windowHandleDeğeriİlkSayfa)) {
                windowHandleDeğeriİkinciSayfa = each;
            }
        }
        driver.switchTo().window(windowHandleDeğeriİkinciSayfa);

        WebElement ikinciSayfaYazıElementi=driver.findElement(By.tagName("h1"));
        String actualİkinciSayfaYazı=ikinciSayfaYazıElementi.getText();
        String expectedİkincSayfaYazısı="Elemental Selenium";

        Assert.assertEquals(actualİkinciSayfaYazı,expectedİkincSayfaYazısı);

    }



}
