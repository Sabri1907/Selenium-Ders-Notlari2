package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        // https:https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        // Cikarsa Cookies'i kabul edin
        // Hesap olustur butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        // radio buttons elementlerini locate edin
        WebElement kadinButton=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkekButton=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozelButton=driver.findElement(By.xpath("//input[@value='-1']"));

        // Secili degilse cinsiyet butonundan size uygun olani secin
        if (!erkekButton.isSelected()){
            erkekButton.click();
        }
        Thread.sleep(3000);

        // digerlerini de secelim
        kadinButton.click();
        Thread.sleep(3000);

        ozelButton.click();


    }



}
