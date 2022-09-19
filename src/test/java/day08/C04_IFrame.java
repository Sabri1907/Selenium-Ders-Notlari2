package day08;

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

public class C04_IFrame {

    /*
        Iframe bir web sayfasina yerlestirilmis baska bir web sayfasidir. Veya bir html dokumanina
    yerlestirilmis baska bir html dokumanidir.
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
        // https://html.com/tags/iframe/ adresine gidiniz.
        driver.get("https://html.com/tags/iframe/");

        // YouTube video'suna tiklayiniz.
        WebElement youTubeFrame=driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        // youTubeFrame.click();
        driver.switchTo().frame(youTubeFrame);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

    }
}
