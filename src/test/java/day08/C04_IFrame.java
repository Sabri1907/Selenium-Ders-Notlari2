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
import java.util.ArrayList;
import java.util.List;

public class C04_IFrame {

    /*
        Iframe bir web sayfasina yerlestirilmis baska bir web sayfasidir. Veya bir html dokumanina
    yerlestirilmis baska bir html dokumanidir.
        Bir web sitesinde bir video (youtube vb.) varsa ve <iframe> tag'i icerisindeyse bu video'yu
    direkt locate edip calistirmak dinamik olmaz. Cunku link degisebilir ve locate'imiz calismaz.
    Bunun icin butun butun frame'leri bir Arraylist'e atip index ile istedigimiz frame'i secip sonrasinda
    "play" tusunu locate edip calistirabiliriz.
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
    public void test1() {
        // https://html.com/tags/iframe/ adresine gidiniz.
        driver.get("https://html.com/tags/iframe/");

        // YouTube video'suna tiklayiniz.
        WebElement youTubeFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        // youTubeFrame.click(); => NOT: Link'le locate ettigimiz icin click() dedigimiz zaman calisti.
        // Ancak link degisirse kodumuz calismaz. Bu yuzden switchTo().frame() methodu kullanmaliyiz.
        // Frame'leri list'e atip hangi frami kullanacaksak onu locate etmeliyiz.

        driver.switchTo().frame(youTubeFrame);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

    }

    @Test
    public void test2() {

        // https://html.com/tags/iframe/ adresine gidiniz.
        driver.get("https://html.com/tags/iframe/");
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();


    }
}
