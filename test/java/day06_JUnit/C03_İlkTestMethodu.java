package day06_JUnit;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_İlkTestMethodu {
    WebDriver driver;

    @Test
    public void test01() {
        //amazon.com'a gidelim ve Title'ın "amazon" içerip içermediğini test edelim
        driver.get("https://amazon.com");
        String actulTitle=driver.getTitle();
        String arananKelime="amazon";

        if (actulTitle.contains(arananKelime)){
            System.out.println("amazon title testi PASSED");
        }else{
            System.out.println("amazon title testi FAILED");
        }

    }

    @Test
    public void test02() {
        //google'a gidelim ve başlığın "google" içerip içermediğini test edelim
        driver.get("https://www.google.com/");
        String actulTitle=driver.getTitle();
        String arananKelime="google";

        if (actulTitle.contains(arananKelime)){
            System.out.println("google title testi PASSED");
        }else{
            System.out.println("google title testi FAILED");
        }


    }

    @Before
    public void ayarlarıDüzenle() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void ortalığıTopla(){
    driver.close();

    }








}