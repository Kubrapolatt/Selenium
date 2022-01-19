package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodları {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        System.out.println(driver.getTitle());//sayfanın title'ını getirir   **Amazon.com. Spend less. Smile more.**

        System.out.println(driver.getCurrentUrl());//sayfanın url'ini getirir   **https://www.amazon.com/**

        System.out.println(driver.getWindowHandle());//her bir sayfa için chrome'un ürettiği numarayı döndürür
        // her çalıştığında farklı numaralar döndürür **CDwindow-A0DA0F1A271FF9370A4CC3A29C9B2339 gibi **

        System.out.println(driver.getPageSource());//


    }
}
