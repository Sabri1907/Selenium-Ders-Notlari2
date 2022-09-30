package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        // Amazon sayfasina gidelim tum sayfanin resmini alalim
        driver.get("https://www.bestbuy.com");

        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/allPage"+tarih+".jpeg"));
        // => Ekran goruntulerini kaydetmek icin genelde target klasoru kullanilir.

        /*
            Bir web sayfasinin ekran goruntusunu almak icin  TakesScreenShot class'indan bir obje olusturup
        gecici bir File Class'indan degiskene  TakesScreenShot'dan olusturdugumuz obje'den getScreenShotAs()
        methodunu kullanarak gecici bir file olustururuz.
         */

        /*
         NOT => Target'ta olusturdugumuz klasordeki dosya yoluna hangi sayfaya gidersek ayni dosya
        ustune yazdiriyor. Bunun onune gecmek icin LocalDateTime olusturarak dosya yoluna ekledik ve
        her ekran goruntusu aldiginda tarih sirasina gore alt alta siraladi.
            Ve bunu TestBaseBeforeAfter class'ina atarak her testimizde kullanabilecegiz.

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(formatter);
        System.out.println(tarih);
        */



    }
}
