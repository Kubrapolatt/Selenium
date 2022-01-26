package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {

    @Test
    public void test(){

        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(a,b,"1.Test Başarısız."); //failed
        softAssert.assertTrue(a>b,"2.Test Başarısız."); //failed
        softAssert.assertTrue(a<c,"3.Test Başarısız."); //passed
        softAssert.assertTrue(c>b,"4.Test Başarısız."); //failed
        softAssert.assertTrue(c<a,"5.Test Başarısız."); //failed

        softAssert.assertAll(); // softAssert.assertAll(); demezsek passed yazar,çünkü aslında raporlama yapmaz sadece kodlar çalışmış olur
    }

}
