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

public class C02_Alerts {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // => https://the-internet.herokuapp.com/javascript_alerts adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

    // 1. butona tiklayin, uyaridaki OK butonunu tiklayin ve result mesajinin
    //"You successfully clicked an alert" oldugunu test edin.
    driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
    Thread.sleep(3000);
    driver.switchTo().alert().accept();
        WebElement mesaj= driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj=mesaj.getText();
        String expectedMesaj="You successfully clicked an alert";
        Assert.assertEquals(expectedMesaj,actualMesaj);
    }

    @Test
    public void test2() throws InterruptedException {

        // 2. butona tiklayin, uyaridaki cancel (iptal) butonunu tiklayin once uyari mesajini alinz
        // sonra result mesajinin "successfuly" icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);

        //Alert uzerindeki mesaji yazdirin
        String uyariMesaji=driver.switchTo().alert().getText();
        System.out.println("2. Kutunun Alert Mesaji = " + uyariMesaji);

        // Cancel (iptal) butonuna tiklayalim
        driver.switchTo().alert().dismiss();

        WebElement mesaj2= driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualMesaj2=mesaj2.getText();
        String expectedKelime="successfuly";
        Assert.assertFalse(actualMesaj2.contains(expectedKelime));
    }

    @Test
    public void test3() throws InterruptedException {

        // 3. butona tiklayin, uyaridaki metin kutusuna isminizi yazin, Ok butonuna tiklayin
        //ve result mesajinda isminizin goruntulendigini dogrulayin.

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);

        //Alert uzerindeki mesaji yazdirin
        String uyariMesaji=driver.switchTo().alert().getText();
        System.out.println("3. Kutunun Alert Mesaji = " + uyariMesaji);

        // Metin kutusuna ismimizi yazip ok butonuna basalim
        driver.switchTo().alert().sendKeys("Yusuf Kerem GUVENDI");
        driver.switchTo().alert().accept();
        String mesaj3= driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj3="Yusuf Kerem GUVENDI";
        Assert.assertTrue(mesaj3.contains(expectedMesaj3));


    }
}
