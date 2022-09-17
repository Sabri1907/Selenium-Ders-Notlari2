package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertion {
     /*
    => https://www.youtube.com/ adresine gidin. Asagidaki testleri yapin.
    1. Sayfa basliginin "YouTube" oldugunu test edin
    2. YouTube resminin goruntulendigini test edin.
    3. Search Box'in erisilebilir oldugunu test edin. (is enabled)
    4. Sayfa basliginin "youtube" olmadigini test edin.
    */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
    }

    @Test
    public void test1(){
        // 1. Sayfa basliginin "YouTube" oldugunu test edin
        String expectedTitle="YouTube";
        String actualtitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualtitle);

    }

    @Test
    public void test2(){
        // 2. YouTube resminin goruntulendigini test edin.
        WebElement youtubeLogo=driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());

    }

    @Test
    public void test3(){
        // 3. Search Box'in erisilebilir oldugunu test edin. (is enabled)
        WebElement searchBox=driver.findElement(By.xpath("(//*[@id='search'])[3]"));
        Assert.assertTrue(searchBox.isEnabled());

    }

    @Test
    public void test4(){
        //  4. Sayfa basliginin "youtube" olmadigini test edin.
        String actualTitle=driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertNotEquals(expectedTitle,actualTitle);

    }
}
