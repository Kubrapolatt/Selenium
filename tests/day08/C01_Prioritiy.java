package tests.day08;

import org.testng.annotations.Test;

public class C01_Prioritiy {


    @Test(priority = -9)
    public void youtubeTest(){
        System.out.println("Youtube testi çalıştı.");
    }

    @Test
    public void amazonTest(){
        System.out.println("Amazon testi çalıştı.");
    }

    @Test(priority = 20)
    public void bestbuyTesti(){
        System.out.println("Bestbuy testi çalıştı.");
    }



}
