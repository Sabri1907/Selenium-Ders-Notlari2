package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //1- https://www.facebook.com adresine gidelim  2- Yeni hesap olustur butonuna basalim
        driver.get("https://www.facebook.com");

        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim=driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        isim.sendKeys("Yusuf Kerem");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("GUVENDI")
                .sendKeys(Keys.TAB).sendKeys("ykg@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("ykg@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("Ykg123456")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB).sendKeys("Tem")
                .sendKeys(Keys.TAB).sendKeys("1990")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT) // Sag yon tusuna basar
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)

                // 4- Kaydol tusuna basalim
                .sendKeys(Keys.ENTER).perform();

        // 4- Kaydol tusuna basalim
    }
}
