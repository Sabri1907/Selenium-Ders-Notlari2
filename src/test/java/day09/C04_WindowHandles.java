package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandles {

    /*
        Bazen bir linke vb. tikladigimizda otomatik olarak yeni bir sayfa acilir. Bu durumda
    acilan yeni sayfanin handle degerini WondowHandle() methoduyla alamayiz. Bunu sorunu
    WindowHandles methodu kullanarak su sekilde cozeriz.
        1. Once arraylist olusturup acik olan sayfalarin handle degerlerini driver.getWindowHandles()
           methoduyla ArrayList'e atariz.
        2. Arraylist'in index yapisindan faydalanarak hangi sayfaya gitmek istersek o sayfanin index'i ile
           handle degerine ulasip kullaniriz.
           =>ORNEK:driver.switchTo().winfow(listAdi.get(1))
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
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        /*
        Bir web sitesine gittigimizde
         */
        List<String> windowList=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        Thread.sleep(3000);

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window",driver.getTitle());

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3")).getText());

        //  Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(3000);
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet",driver.getTitle());

        // Sayfaları Kapatalım
        Thread.sleep(3000);
        driver.quit();

    }

}
