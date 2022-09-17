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

public class C02_Assertion {
    /*
    => https://www.amazon.com adresine gidelim. Asagidaki testleri yapalim.
    1. Url'nin Amazon icerdigini test edelim
    2. Title'in facebook icermedigini test edelim
    3. Sol ust kosede amazon logosunun gorundugunu test edelim.
    4. Url'nin https://www.facebook.com olmadigini tes edin.
    */


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        // Butun test'leri amazon sayfasinda yapacagimiz icin her test methodunda ayri ayri
        // amazon sayfasina gitmemek icin Before Class'inin olusturduk.
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test1(){
        //1. Url'nin Amazon icerdigini test edelim
       String expectedUrl="amazon";
       String actualUrl=driver.getCurrentUrl();
       Assert.assertTrue(actualUrl.contains(expectedUrl));

    }

    @Test
    public void test2(){
        //2. Title'in facebook icermedigini test edelim
        String actualTitle=driver.getTitle();
        String expectedTitle="facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }

    @Test
    public void test3(){
        //3. Sol ust kosede amazon logosunun gorundugunu test edelim.
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test4(){
        //4. Url'nin https://www.facebook.com olmadigini tes edin.
       String expectedUrl="https://www.facebook.com";
       String actualUrl=driver.getCurrentUrl();
       Assert.assertNotEquals(expectedUrl,actualUrl);

    }

}
