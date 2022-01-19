package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_TekrarTesti {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

     //  1. Bir class oluşturun : AmazonSearchTest
     //  2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
     //  a.google web sayfasına gidin. https://www.amazon.com/

        driver.get("https://www.amazon.com/");

     //  b. Search(ara) “city bike”

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike"+Keys.ENTER);
       // aramaKutusu.submit(); keys.enter yerine bu da kullanılabilir

     //  c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın

      List<WebElement> sonuçYazısıElementi= driver.findElements(By.className("sg-col-inner"));
      System.out.println("Sonuç Sayısı : "+sonuçYazısıElementi.size());

      //  e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

      /*WebElement ilkUrunResim= driver.findElement(By.className("s-image"));
      ilkUrunResim.click();*/

        //sadece click yapmak gibi basit bir işlemde kullanacağımız webelementler için
        //variable oluşurmadan direk locate edip isteediğimiz işlemi yapabiliriz

        driver.findElement(By.className("s-image")).click();
















    }
}
