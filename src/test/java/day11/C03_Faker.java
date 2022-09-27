package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement isim=driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions=new Actions(driver);
        String email= faker.internet().emailAddress(); // email adresini iki kez yazmamizi istedigi icin random atarken aynisini
        // yazmayacagi icin aynisini tekrarlamasi icin emaili bir string'e atayip kullandik.

        /*
            Faker class'ini kullanma amacimiz form doldurmamiz gereken web sitelerinde defalarca kendi uretecegimiz
        veriler yerine bizim yerimize random veriler uretir ve bizim isimizi kolaylastirir.
            Faker class'ini kullanmak icin mvnrepository.com adresinden java-faker kutuphanesini aratip
        en cok kullanilani pom.xml dosyasmiza ekleriz.
            Faker class'indan bir obje olusturup:
        =>email icin faker.internet() methodunu kullanarak emailAddress() methodunu seceriz.
        =>password icin faker.internet().password() methodu kullanilir.
        =>isim ve soyisimler icin faker.name().firstName() ve faker.name().lastName() methodlari kullanilir.
         */

        actions.click(isim).sendKeys(faker.name().firstName())

                //“surname” giris kutusuna bir soyisim yazin
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB).sendKeys("Tem")
                .sendKeys(Keys.TAB).sendKeys("1990")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT) // Sag yon tusuna basar
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();




        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Kaydol butonuna basın
        //Sayfayi kapatin
    }
}
