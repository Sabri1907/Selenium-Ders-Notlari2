package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Action_PageDown extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        // Automationexzercises.com adresine gidelim
        driver.get("https://automationexercise.com");

        // Product bolumune gidelim
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        Thread.sleep(3000);

        // Ilk urune tiklayin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform(); // Bazen sayfanin gorunmeyen kisminda
        // locate ettigimiz urunu tiklamayabilir. Bu durumda Actions class'indan PAGE_DOWN ozelligini
        // kullanarak satfayi asagi kaydirirarak urunu tiklariz.
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();
    }
}
