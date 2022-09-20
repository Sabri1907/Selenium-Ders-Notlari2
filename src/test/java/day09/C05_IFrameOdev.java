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
import java.util.ArrayList;
import java.util.List;

public class C05_IFrameOdev {

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
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

       // 2)        sayfadaki iframe sayısını bulunuz.
        List<WebElement> frameList=driver.findElements(By.xpath("//iframe"));
        System.out.println("Frame Sayisi: "+frameList.size());

        //3)        ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement frame1= driver.findElement(By.xpath("//iframe[1]"));
        driver.switchTo().frame(frame1);
        //WebElement play1=driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        //play1.click();

      //  4)        ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

       // 5)        ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        //WebElement frame2= driver.findElement(By.xpath("//iframe[2]"));
       // driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//*[@href='https://www.guru99.com/live-selenium-project.html']")).click();





    }

}
