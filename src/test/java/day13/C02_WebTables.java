package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        // login methodu olusturun ve oturum acin
        login();

        // Table methodu olusturun
        table();




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

    private void table() {

        /* Tabloda <table> tag'i altinda tablonun basligini gosteren <thead> tag'i bulunur.
        => Basliktaki sutunlara yani hucrelere <th> tag'i ile ulasilir.
        => Eger baslikta satir (row) varsa <thead> tag'i altinda <tr> (row) tag'i vardir.
        => Basligin altindaki satirlara <tbody> tag'i altinda <tr> tag'i ile,
           hucrelere (sutunlara) ise <td> tag'i ile ulasilir.
         */

        // Tum table body'sinin boyutunu (sutun sayisini) bulun
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun Sayisi: "+sutunSayisi.size());

        //Table'daki tum body'i ve basliklari (headers) konsolda yazdirin
            // Once basliklari yazdiralim
        WebElement basliklar=driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar: "+basliklar.getText());

            // Tum body'i yazdiralim
        WebElement body=driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum Body: "+body.getText());

        // Table body'sinde bulunan toplam satir (row) sayisini bulun
        List<WebElement> bodySatirSayisi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki satir sayisi: "+bodySatirSayisi.size());

        // Table body'sinde bulunan satirlari konsolda yazdirin

        bodySatirSayisi.stream().forEach(t-> System.out.println(t.getText()));

        // 4.satirdaki elementleri konsolda yazdirin
        System.out.println(
                "4.Satir: "+driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }


}
