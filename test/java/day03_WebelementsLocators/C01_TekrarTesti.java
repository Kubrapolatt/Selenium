package day03_WebelementsLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        //1. Yeni bir class olusturun (TekrarTesti)

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify),
        // eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.

        driver.navigate().to("https://youtube.com");
        String actualTitleYoutube=driver.getTitle();
        String expectedTitle="youtube";
        if (actualTitleYoutube.equals(expectedTitle)){
            System.out.println("Youtube title testi PASS");
        }else {
            System.out.println("Youtube title testi FAILED \nactual sayfa başlığı : " + actualTitleYoutube);
        }
        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String actualYoutubeUrl=driver.getTitle();
        String arananKelimeYoutube="youtube";
        if (actualTitleYoutube.equals(arananKelimeYoutube)){
            System.out.println("Youtube url testi PASS");
        }else {
            System.out.println("Youtube url testi FAILED \nactual Youtube Url : "+actualYoutubeUrl);
        }

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        //7. Amazon sayfasina donun
        driver.navigate().forward();

        //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
        String actualTitleAmazon= driver.getTitle();
        String amazonTitleArananKelime="Amazon";

        if (actualTitleAmazon.contains(amazonTitleArananKelime)){
            System.out.println("Amazon title testi PASS");
        }else {
            System.out.println("Amazon title testi FAILED \nActual Amazon Title : "+actualTitleAmazon);
        }

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın

        String expectedAmazonUrl="https://www.amazon.com/";
        String actualAmazonUrl= driver.getCurrentUrl();

        if (expectedAmazonUrl.equals(actualAmazonUrl)){
            System.out.println("Amazon url testi PASS");
        }else{
            System.out.println("Amazon url testi FAILED \nActual Amazon Url Testi : "+actualAmazonUrl);
       }

        //11.Sayfayi kapatin

        driver.close();

    }
}
