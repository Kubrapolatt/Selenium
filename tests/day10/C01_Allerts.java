package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Allerts {

    WebDriver driver;
    WebElement sonuçYazısıElementi;

    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

    @BeforeClass
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
}
    @Test
    public void acceptAllert() throws InterruptedException {
    //● Bir metod olusturun: acceptAlert
    //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın
    //ve result mesajının “You successfully clicked an alert” oldugunu test edin.
    driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
    Thread.sleep(3000);
    driver.switchTo().alert().accept();
    sonuçYazısıElementi= driver.findElement(By.xpath("//p[@id='result']]"));
    Thread.sleep(3000);
    String actualSonuçYazısı=sonuçYazısıElementi.getText();
    String expectedSonuçYazısı="You successfully clicked an alert";

    Assert.assertEquals(actualSonuçYazısı,expectedSonuçYazısı);
}
    @Test
    public void dismissAlert() throws InterruptedException {
        //● Bir metod olusturun: dismissAlert
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        //“successfuly” icermedigini test edin.
        sonuçYazısıElementi= driver.findElement(By.xpath("//p[@id='result']]"));
        Thread.sleep(3000);
        String actualSonuçYazısı=sonuçYazısıElementi.getText();
        String istenmeyenKelime="successfuly";

        Assert.assertFalse(actualSonuçYazısı.contains(istenmeyenKelime));
    }
    @Test
    public void sendKeysAlert() throws InterruptedException {
         //● Bir metod olusturun: sendKeysAlert
        // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Kübra");
        driver.switchTo().alert().accept();
        // OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        Thread.sleep(3000);
        sonuçYazısıElementi= driver.findElement(By.xpath("//p[@id='result']]"));
        String actualSonuçYazısı=sonuçYazısıElementi.getText();
        String arananKelime="Kübra";

        Assert.assertTrue(actualSonuçYazısı.contains(arananKelime));
    }

    @AfterClass
    public void teardown(){
       driver.close();
    }
}
