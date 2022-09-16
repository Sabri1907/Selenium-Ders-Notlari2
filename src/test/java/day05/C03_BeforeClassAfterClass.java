package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
    => Before Class / After Class notasyonuyla kullanilan methodlar static olmalidir.
       Test notasyonuyla kullanilan methodlar static olmak zorunda degildir.
    => Before / After'dan farki: Before/After kullanildiginda ilgili class'daki her test'ten once
       before ve her test'ten sonra after methodu calisir.
       - BeforeClass / AfterClass kullanildiginda ise ilgili clas calistirildiginda bir kez BeforeClass calisir,
       sonra test methodlari calisir ve en sonunda bir kez AfterClass methodu calisir.
       - Ilgili class'daki tek test calistirildiginda ise before/after'da oldugu gibi test'ten once BeforeClass,
         test'ten sonra ise AfterClass calisir.
         ================================> NOT <=========================================================
    => Before/After ve BeforeClass/AfterClass bir arada kullanilirsa BeforeClass ve AfterClass class basinda
    ve sonunda bir kez calisir. Before ve after ise her testten once ve sonra calisir.

     */
    static WebDriver driver;

    @BeforeClass
    public  static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    @Ignore // Calismasini istemedigimiz test'lerin onune ignore notasyonu kullaniriz.
    public void method1(){
        driver.get("https://amazon.com");
    }

    @Test
    public void method2(){
        driver.get("https://techproeducation.com");
    }


    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
