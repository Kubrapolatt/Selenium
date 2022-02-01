package tests.day13;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )

    @Test
    public void downloadTesti() throws InterruptedException {
        //3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
        //- https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //- download.png dosyasını indirelim
        driver.findElement(By.xpath("//a[.='download.png']")).click();
        Thread.sleep(5000);
    }

    @Test
    public void isExistTesti(){
        //4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\download.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
