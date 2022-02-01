package tests.day13;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Senkronizasyon extends TestBase {

    @Test
    public void test01() throws InterruptedException {
       /*
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-submit")).click();
    */
        /*
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//yt-formatted-string[text()='I Agree']")).click();
    */
       /* driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("(//a[text()='info@techproeducation.com'])[2]")).click();*/

        //https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin disable butonuna basın
        // sonrada disabled yazısının çıktığını test edin

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()="));
        Thread.sleep(5000);


    }




}
