package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAyrıTestler {

   static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void urlTesti(){
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin

        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://www.bestbuy.com/";

        Assert.assertEquals("Lütfen test değerlerini gözden geçirin",expectedUrl,actualUrl);
    }
    @Test
    public void titleTesti(){
        //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle= driver.getTitle();
        String istenmeyenKelime="Rest";

        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
    @Test
    public void logoTesti(){
        //		○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("Logo Görünmüyor",logoElementi.isDisplayed());
    }

    @Test
    public void francaisTesti(){
        //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francais= driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francais.isDisplayed());
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

}
