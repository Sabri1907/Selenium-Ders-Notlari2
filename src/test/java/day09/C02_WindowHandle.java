package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {


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
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();
        /*
            Eger bize verilen task'te sayfalar arasi gecis varsa her driver.get() ile sayfa actiktan sonra
        o sayfanin window handle degerini alip String degere atariz.
            Farkli sayfaya gittikten sonra onceki sayfamiza donmek istersek;
        driver.switchTo().window(WindowHandle Degeri) methodunun icine String'e atadigimiz ilgili WindowHandle
        degerini yazariz.
         */

        //2- Url'nin amazon içerdiğini test edelim
        String actualUrl=driver.getCurrentUrl();
        String expectedKelime="amazon";
        Assert.assertTrue(actualUrl.contains(expectedKelime));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyHandle=driver.getWindowHandle(); // Gecis yapmak icin handle degerini aldik
        Thread.sleep(3000);

        //4- title'in BestBuy içerdiğini test edelim
        String actualTitle=driver.getTitle();
        String expectedTitle="Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime="Java";
        String aramaSonucu2=aramaSonucu.getText();
        Assert.assertTrue(aramaSonucu2.contains(arananKelime));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyHandle);

        //8- Logonun görünürlüğünü test edelim
        WebElement logo=driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

        //9- Sayfaları Kapatalım
        Thread.sleep(3000);
        driver.quit();

    }

}
