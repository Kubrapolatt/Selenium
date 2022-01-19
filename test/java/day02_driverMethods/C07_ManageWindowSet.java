package day02_driverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class C07_ManageWindowSet {
    public static void main(String[] args) throws InterruptedException {
     //  1. Yeni bir Class olusturalim.C07_ManageWindowSet
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
     //  2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
     //  3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
     //  4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage( ).window( ).setPosition(new Point(650,900));
        driver.manage( ).window( ).setSize(new Dimension(300,500));

     //  5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin

        int xKoordinatı=driver.manage().window().getPosition().getX();
        int yKoordiinatı=driver.manage().window().getPosition().getY();
        int genişlik=driver.manage().window().getSize().getWidth();
        int yükseklik=driver.manage().window().getSize().getHeight();

        Thread.sleep(3000);

        if (xKoordinatı==650 & yKoordiinatı==900 & genişlik==300 & yükseklik==500){
            System.out.println("Ölçeklendirme testi PASS");
        }else {
            System.out.println("Ölçeklendirme testi FAİLED");
        }
     //  8. Sayfayi kapatin

       driver.close();












    }
}
