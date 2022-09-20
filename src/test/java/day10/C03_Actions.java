package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1(){
        // Amazon sayfasina gidelim.
        driver.get("https://amazon.com");

        // Account menusunden create a list linkine tiklayalim
        WebElement account=driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions actions=new Actions(driver);
       actions.moveToElement(account).perform();

        /*
            Bir web sitesinde bir webelementin mause ile acilan bir webelementi'ne ulasmak istersek;
        actions.moveToelement() methodunu kullanmamiz gerekir.
            Aksi takdirde html kodlari arasinda webelementi bulur ama ulasamadigi icin
        "ElementNotInteractableException: element not interactable" exception'i firlatir.
         */

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }
}
