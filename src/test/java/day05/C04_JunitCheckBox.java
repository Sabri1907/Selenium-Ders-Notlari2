package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_JunitCheckBox {
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
        // https://the-internet.herokuapp.com/checkboxes adresine gidin
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // checkbox1 checkbox2 elementlerini locate diniz
        WebElement checkbox1=driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        Thread.sleep(3000);

        // checkbox1 secili degilse onay kutusunu tiklayin
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        Thread.sleep(3000);

        // checkbox2 secili degilse onay kutusunu tiklayin
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }

    }
}
