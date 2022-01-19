package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Tekrar {

    public static void main(String[] args) throws InterruptedException {

        //Normalde selenium'un kendi IDE'si var fakat biz kullanışlı olduğu için intellij kullanıyoruz
        //İntellij'de yeni bir proje açtığımızda öncelikle selenium kütüphanelerini projeye eklememiz gerekir
        //Biz en ilkel haliyle projemize kütüphaneleri jar dosyaları olarak yükledik
        //bu eklediğimiz dosyalarla artık driver'ın ayarlarını yapabliriz


        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        //setProperty() iki parametre ister ilki kullanacağımız browser'a ait driver ismi
        // ikinci parametre ise selenium sitesinde indirip projemze eklediğimiz chrome driver'ın pathi
        //windows kullanıcıları sona .exe eklerken mac kullananlar .exe eklememeli

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        Thread.sleep(5000);
        //javadan gelir,içine yazılan mini sn kadar kodların çalışmasını durdurur

        driver.close();
        //driver.close() class'ın sonun ayzılşır çünkü bu kod çalışınca driver'ımız kapanır.
        //Bu koddan sonra yeniden bir browser açmak istiyorsak driver'a yeni değer atamalıyız.


        driver=new ChromeDriver();


















    }


}
