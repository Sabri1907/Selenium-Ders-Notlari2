package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // Bir onceki class'daki siteye login methoduyla sayfaya giris yapin
        login();
        int satir=3;
        int sutun=4;

        // input olarak verilen satir sayisi ve sutun sayisina sahip cell'deki text'i yazdirin
        WebElement cell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("Istenen satir ve sutundaki Text: "+cell.getText());

        // Price basligindaki tum numaralari yazdirin.
        List<WebElement> priceList=driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement each:priceList) {
            System.out.println(each.getText());

        }






    }

    private void login() {
        // https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        // Oturum acin
        // userName : manager
        // Password : Manager1!
        Actions action=new Actions(driver);
        WebElement userName=driver.findElement(By.xpath("//*[@id='UserName']"));
        action.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!")
                .sendKeys(Keys.ENTER).perform();
    }


}
