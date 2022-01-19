package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_ManageWindow {
    public static void main(String[] args) throws InterruptedException {

        //  1. Yeni bir Class olusturalim.C06_ManageWindow

        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();


       //  2. Amazon soyfasina gidelim. https://www.amazon.com/

        driver.get("https://www.amazon.com/");

        //  3. Sayfanin konumunu ve boyutlarini yazdirin

        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        //  4. Sayfayi simge durumuna getirin

        driver.manage().window().minimize();

       //  5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin

        Thread.sleep(3000);
        driver.manage().window().maximize();

      //  6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin

        System.out.println("Maxmizie durumunda position : "+driver.manage().window().getPosition());
        System.out.println("Maxmizie durumunda size : "+driver.manage().window().getSize());


        //  7. Sayfayi fullscreen yapin

        Thread.sleep(3000);
        driver.manage().window().fullscreen();

      //  8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin

        Thread.sleep(3000);
        System.out.println("Fullscreen durumunda position : "+driver.manage().window().getPosition());
        System.out.println("Fullscreen durumunda size : "+driver.manage().window().getSize());

      //  8. Sayfayi kapatin

        driver.close();









    }
}