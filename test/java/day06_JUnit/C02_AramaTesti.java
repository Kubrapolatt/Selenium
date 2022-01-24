package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameBox= driver.findElement(By.xpath("//input[@class='input_error form_input']"));
        usernameBox.sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordBox= driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
       WebElement ilkUrunElementi= driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
       String ilkUrunIsmı=ilkUrunElementi.getText();
       ilkUrunElementi.click();
       //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
        //7. Alisveris sepetine tiklayin
        WebElement alışverişSepeti=driver.findElement(By.className("shopping_cart_link"));
        alışverişSepeti.click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
       WebElement sepettekiUrunIsmiElementi= driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
       String sepettekiUrunİsmi=sepettekiUrunIsmiElementi.getText();

       if (sepettekiUrunİsmi.equals(ilkUrunIsmı)){
           System.out.println("Alışveriş test PASSED");
       }else{
           System.out.println("Alışveriş testi FAILED");
       }
        //9. Sayfayi kapatin
        driver.close();

    }
}
