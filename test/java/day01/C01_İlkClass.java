package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_İlkClass {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        //biz driver objesi oluşturduğumuzda boş bir browser açılır.

        driver.get("https://www.amazon.com");
        //driver.get() method'u driver'a gideceği web adresini girmemizi sağlar

        Thread.sleep(3000);//açıyor 3 sn bekliyor ve kapatıyor

        driver.close(); // driver'ı kapatır//

    }

}
