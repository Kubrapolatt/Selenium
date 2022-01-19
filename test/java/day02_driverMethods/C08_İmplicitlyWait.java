package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C08_İmplicitlyWait {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //implicitlyWait testimiz boyunca sayfa açılması ve element bulunması
        //konusunda driver'ın bekleyeceği max süreyi belirler
        //Bu süre içerisinde görevini bitirir bitirmez bir sonraki adıma geçer
        //Bu süre içerisinde görevini biteremezse o zaman hata verir

        //Belirlenen max süre Thread.sleep'deki gibi mutlak bekleme süresi değildir


        driver.get("https://techproeducation.com");
        // Thread.sleep(5000);

        driver.close();











    }
}
