package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExist {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home"));  //C:\Users\kubra

        //masaüstündeki deneme klasörünün Path'ini istesem
        //"C:\Users\kubra\Desktop\deneme\selenium.docx"

        //Yani dinamik olarak masaüstündeki deneme klasörünün path'ini yazmak istesem
        String path=System.getProperty("user.home")+"\\Desktop\\deneme\\selenium.docx";  //C:\Users\kubra\Desktop\deneme\selenium.docx

        System.out.println(path);

        System.out.println("user.dir : "+System.getProperty("user.dir")); //user.dir : C:\Users\kubra\IdeaProjects\com.TestNGBatch44

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\deneme\\selenium.docx";

        System.out.println(Files.exists(Paths.get(dosyaYolu))); //false
        //projemizde pom.xml olduğunu test edin
        //C:\Users\kubra\IdeaProjects\com.TestNGBatch44\pom.xml

        System.out.println(System.getProperty("user.dir"));//projenşn yolunu verir

        // Masaustunde Deneme klasoru icerisinde selenium.xlsx isminde bir dosya oldugunu test edin
        // 1- once bu dosyaya ulasmak icin gerekli dinamik path olusturalim
       //C:\Users\kubra\IdeaProjects\com.TestNGBatch44

        String pomPath=System.getProperty("user.dir")+"\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));

    }
}
