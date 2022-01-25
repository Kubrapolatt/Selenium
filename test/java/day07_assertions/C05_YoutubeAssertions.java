package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class C05_YoutubeAssertions {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void titleTest(){
        //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        driver.get("https://www.youtube.com");
       String actualTitleTest= driver.getTitle();
       String istenenKelime="Youtube";

        Assert.assertTrue(actualTitleTest.contains(istenenKelime));

    }

    @Test
    public void imageTest(){
        //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
   WebElement youtubeResimKontrol= driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-logo']"));

   Assert.assertTrue(youtubeResimKontrol.isDisplayed());

    }
    @Test
    public void searchBoxTest(){
        //     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxErişimTesti= driver.findElement(By.xpath("//input[@id='search']"));

        Assert.assertTrue(searchBoxErişimTesti.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String wrongTitle= driver.getTitle();
        String istenmeyenKelime="youtube";

        Assert.assertFalse(wrongTitle.contains(istenmeyenKelime));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
