package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {

         /*
            Eger bize verilen task'te sayfalar arasi gecis varsa her driver.get() ile sayfa actiktan sonra
        o sayfanin window handle degerini alip String degere atariz.
            Farkli sayfaya gittikten sonra onceki sayfamiza donmek istersek;
        driver.switchTo().window(WindowHandle Degeri) methodunun icine String'e atadigimiz ilgili WindowHandle
        degerini yazariz.
         */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        // Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");

        // Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle=driver.getWindowHandle();

        // Title'in Amazon içerdiğini test edelim
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");

        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        // Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertTrue(driver.getTitle().equals(actualTitle));



        // Sayfaları Kapatalım
        Thread.sleep(3000);
        driver.quit();

    }

}
