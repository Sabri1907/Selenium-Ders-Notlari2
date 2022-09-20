package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        /*
          -Cizgili alan uzerinde sag click yapalim
         NOT:
         1. Sag tik yapinca alert cikti. Bunun icin cizgili alani locate etmek icin baska bir yerden
         incele deyip html kodlarina ulastik ve once cizgili alani locate ettik.
         2. Daha sonra da  actions objesiyle sag click yapabildik ve cikan alerti switchTo() methodu ile
         kullanabildik.
        */


        WebElement cizgiliAlan= driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();


        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        // Tamam diyerek alert’i kapatalim
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();


        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        // Yeni sayfa acildigi icin windowhandle degerlerini array'a atip ikinci sayfaya
        //gidip locate edebildik.
        List<String> windowList=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        String expectedh1="Elemental Selenium";
        String actualh1=driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedh1,actualh1);



    }
}
