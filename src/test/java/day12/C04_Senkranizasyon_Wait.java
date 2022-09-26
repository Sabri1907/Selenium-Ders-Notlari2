package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C04_Senkranizasyon_Wait extends TestBaseBeforeAfter {
    @Test
    public void isEnableTest1() {
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Textbox'in etkin olmadigini (enabled) dogrulayin
        WebElement textBox=driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        // Enable butonuna tiklayin ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        //=> wait until elementToBeClickable() methoduyla Textbox'in etkin oluncaya kadar beklettik.

        //"It's enabled!" mesajinin gorundugunu dogrulayin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        // Textbox'in etkin oldugunu (enable) dogrulayin
        Assert.assertTrue(textBox.isEnabled());



    }
}
