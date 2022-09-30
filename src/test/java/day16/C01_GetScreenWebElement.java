package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenWebElement extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {

        // Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        // Nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        // Arama sonucunun resmini alalim
        WebElement aramaSonucu=driver.findElement
                               (By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        // NOT => Sadece webelementin resmini ekran goruntusu alacaksak TakeScreenShot class'ini
        // kullanmama gerek yok.
        // Locate ettigimiz webelementi direk gecici bir file'a atip FileUtils ile kopyalayip
        // yolunu (path) belirtiriz.
        File nutellaAramaSonucu=aramaSonucu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekrangoruntusuWebElement/WESS"+tarih+".jpeg"));
    }
}
