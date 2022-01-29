package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {

    //● Tests package’inda yeni bir class olusturun: WindowHandle2

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement çıkanTextElementi= driver.findElement(By.tagName("h3"));

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(çıkanTextElementi.getText(),"Opening a new window","Sayfadaki yazı beklenenden farklı.");


        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        softAssert.assertEquals(driver.getTitle(),"The Internet","Sayfa title'ı beklenenden farklı.");

        //● Click Here butonuna basın.
        //soruda window handle değerini bilmediğm bir window açılıyor.O sayfanın window handle değerini
        // bulmak için geçtiğim sayfalardaki window handle değerlerini kaydetmeliyim

        String windowHandleDeğeri1= driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
       //önce açılan yeni sayfanın handle değerini elde etmeliyim

       //1- tüm handle değrlerini alıp bir set'e koyalım
        Set<String> handleDeğerleriSeti=driver.getWindowHandles();
        String windowHandleDeğeri2="";

        for (String each:handleDeğerleriSeti
             ) {
            if (!each.equals(windowHandleDeğeri1)){
                windowHandleDeğeri2=each;
            }
        }
       //artık yeni sayfaya geçiş yapabiliriz
        driver.switchTo().window(windowHandleDeğeri2);
        softAssert.assertEquals(driver.getTitle(),"New Window","Sayfa başlığı bekleneni karşılamıyor.");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement ikinciSayfadaÇıkanText=driver.findElement(By.tagName("h3"));

        softAssert.assertEquals(ikinciSayfadaÇıkanText.getText(),"New Window","İkinci sayfadaçıkan text bekleneni karşılamıyor.");

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(windowHandleDeğeri1);
        softAssert.assertEquals(driver.getTitle(),"The Internet","İlk sayfanın title'ı beklenen gibi değil.");

        softAssert.assertAll();
    }


    @AfterClass
    public void teardown(){
     driver.quit();
    }
}
