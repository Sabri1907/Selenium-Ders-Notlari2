package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {
    /*
    =======================================BASIC AUTHENTICATION===============================================
        Bazi sitelere veya uygulamara giris yapmak istedigimizde bizden kullanici adi ve sifre isteyebilir.
    Bunu hic bir sekilde locate edemayiz. Bu gibi durumlarda basic authentication yapisini kullanmamiz gerekir.
     */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }

    @Test
    public void test1(){
        // Basic Authentication yapalim
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Sayfaya basarili bir sekilde giris yapildigini kontrol edelim
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
