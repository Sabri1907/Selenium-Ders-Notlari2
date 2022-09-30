package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JSExecuter extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        // Asagidaki careers butonu gorununceye kadar JavaScript (JS) ile scroll yapalim
        WebElement careers=driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        // => JavascriptExecutor class'indan obje olusturup diver'i atadik ve casting yaptik

        jse.executeScript("arguments[0].scrollIntoView(true);",careers);
        // JS objesiyle birlikte executeScript() methodunu kullanarak istedigimiz webelement gorununceye
        // kadar scroll yaptik

        // Careers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",careers);
        // Careers webelementini js kodu ile click yaptik
    }
}
