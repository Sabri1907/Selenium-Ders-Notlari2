package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions_DragAndDrop extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']")); // Drag'i locate ettik
        WebElement drop= driver.findElement(By.xpath("(//*[@id='droppable'])[1]")); // Drop'u locate ettik

        Actions actions=new Actions(driver); // Actions objemizi olusturduk
        /*
        NOT: Action class'ini Extends yaptigimiz TestBase classinda da olusturabiliriz.
        Bu durumda Test class'inda sadece obje'yi kullaniriz.
         */
        Thread.sleep(3000);
        actions.dragAndDrop(drag,drop).perform();
        // DrapAndDrop() methoduyla once suruklenecek elementi, sonta birakilacak elementi yazdik

        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());

    }

}
