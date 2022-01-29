package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

//Yeni bir class olusturalim: MouseActions2
public class C04_DragAndDrop extends TestBase {

    @Test
    public void dragAndDropTest() throws InterruptedException {

        //1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        Actions actions=new Actions(driver);

        WebElement taşınacakElement=driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement taşınanYerElementi= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(taşınacakElement,taşınanYerElementi).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String actualDroppedYazısı=taşınanYerElementi.getText();
        String expectedDroppedYazısı="Dropped!";

        Assert.assertEquals(actualDroppedYazısı,expectedDroppedYazısı);

        Thread.sleep(5000);
    }







}
