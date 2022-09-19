package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_IFrame {

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
    public void test1() {
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iFrameYAzisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iFrameYAzisi.isDisplayed());

        // Erisebilir text'i yazdiralim
        System.out.println("iframe Yazisi: " + iFrameYAzisi.getText());

        // Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameTextBox = driver.findElement(By.id("mce_0_ifr")); // Frame'i locate ettik
        driver.switchTo().frame(frameTextBox); // Frame'e switchTo() methodu ile gecis yaptik

        WebElement frameTextBox2 = driver.findElement(By.xpath("//p")); // TextBox'i tekrar locate ettik
        frameTextBox2.clear(); // clear() methodu textbox'in icini temizler.
        frameTextBox2.sendKeys("Merhaba Dunya");

        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent(); // Frame'den cikip anasayfa'ya  donduk
        WebElement elemental = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println("Elemental Yazisi: " + elemental.getText());


    }

}
