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

public class C03_Assertion {
     /*
    => https://www.bestbuy.com/ adresine gidin. Asagidaki testleri yapin.
    1. Url'in https://www.bestbuy.com/'a esit oldugunu test edin
    2. Title'in "Rest" icermedigini test edelim
    3. BestBuy logosunun gorundugunu test edelim.
    4. Fransizca linkin goruntulendigini test edin.
    */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test1(){
        // 1. Url'nin https://www.bestbuy.com/ oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }

    @Test
    public void test2(){
        // 2. Title'in "Rest" icermedigini test edelim
        String actualTitle=driver.getTitle();
        String expectedTitle="Rest";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }

    @Test
    public void test3(){
        // 3. BestBuy logosunun gorundugunu test edelim.
        WebElement bestBuyLogo=driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());

    }

    @Test
    public void test4(){
        // 4. Fransizca linkin goruntulendigini test edin.
        WebElement fransizca=driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(fransizca.isDisplayed());

    }
}
