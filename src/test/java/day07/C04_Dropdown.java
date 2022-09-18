package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {

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
        // https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 1. index kullanarak option 1'i secin ve yazdirin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=======================================================");

        // NOT=> ddm.sendKeys("Option 1"); // Select kullanmadan bu sekilde de secebiliriz.

        //2. Value kullanarak Secenek 2'yi secin ve yazdirin
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("================================================");

        //3. Visible text kullanarak secek 1'i secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=================================================");

        // 4. Tum droddown degerlerini yazdirin
        List<WebElement> tumDdm=select.getOptions();
        // Lambda ile: tumDdm.forEach(t-> System.out.println(t.getText()));
        for (WebElement each:tumDdm) {
            System.out.println("Options: "+each.getText());
            System.out.println("==================================================");

        // 5. Dropdown'in boyutunu bulun, Dropdown'da 4 oge varsa konsola true, degilse false yazdirin
            System.out.println("Dropdown Boyutu: "+tumDdm.size());
            if (tumDdm.size()==4){
                System.out.println("True");
            }else System.out.println("False");

            Assert.assertNotEquals(4,tumDdm.size());

            
        }

    }

}
