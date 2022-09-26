package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;



public class C03_Senkranizasyon_Wait extends TestBaseBeforeAfter {

    /*
    => Implicitly wait kullandigimiz zaman belirttigimiz sure; ilgili sayfadaki tum webelementler
    icin maximum bekleme suredir. Bu sure icinde webelementlere ulasamazsa nusuchelement exceptioon'i aliriz.
    Belirtilen surenin altinda herhangi bir surede webelenemte ulasirsa ordan sistem ordan calismaya devam eder.

    */

    @Test
    public void implicitlyWaitTest1() {

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // remove butonuna basin
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // Its'gone yazisinin gorundugunu kontrol edin
        driver.findElement(By.xpath("//*[@id='message']"));

        // Add butonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // It's back yazisinin goruntulendgigini kontrol edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());




    }

    @Test
    public void explicitlytlyWaitTest2() {
        /*
        => Explicitlywait; implicitlywait kullanmadigimiz veya implicitlywait'de belrttigimiz surede inmeyen
         webelementler icin henuz gorulmeyen (inmesi beklenen) bir web elementin locat edilmesi otomasyon
        icin mumkun olmaz. Bu durumda bekleme islemi icin explicitlywait'i locate ile birlikte kullaniriz.
         */

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // remove butonuna basin
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // Its'gone yazisinin gorundugunu kontrol edin
        // => Gorunmesi icin beklenmesi gereken sureyi explicitlyWait ile yapacagiz.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGone= wait.until(ExpectedConditions.
                            visibilityOfElementLocated((By.xpath("//*[@id='message']"))));
        Assert.assertTrue(itsGone.isDisplayed());

        // Add butonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // It's back yazisinin goruntulendgigini kontrol edin
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
        WebElement itsBack=wait.until(ExpectedConditions.
                           visibilityOfElementLocated(By.xpath("//*[@id='message']")));

        Assert.assertTrue(itsBack.isDisplayed());

    }
}
