package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileExist_UpLoad extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // ChooseFile (Dosya sec) butonuna tiklayin
        WebElement dosyaSec=driver.findElement(By.xpath("//*[@id='file-upload']"));
        // => DosyaSec'i locate ettik
        /*
         => NOT: Dosya sec butonunu direkt click yapamayabiliriz. Cunku windows'a mudahaleye izin vermeyebilir.
        Bu yuzden Dosya Sec butonunu locate edip sendKeys() methodu ile string degiskene atradigimiz
        dosya yolunu gondeririz
         */

        String dosyaYolu="C:\\Users\\dell\\Downloads\\test (1).txt";
        // => Yiklemek istedigimiz dosya yolunu kopyaladik

        dosyaSec.sendKeys(dosyaYolu);
        // => Dosya butonuna yolunu kopyaladigimiz dosyayi gonderdik.

        // upload butonuna basin
        driver.findElement(By.id("file-submit")).click();

        // "File Uploaded!" yazisinin goruntulendigini kontrol edin"
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());

    }
}
