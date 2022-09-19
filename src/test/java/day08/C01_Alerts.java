package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

     /*
    Bir web sayfasina girdigimizde bir uyari mesaji ya da bir button'a tikladigimizda
    bir uyari cikabilir. Eger bu uyariya incele yapabiliyorsak bu tur alert'lere "Html Alert" denir.
    Bu tur alert'ler locate edilebilir.
        Ancak gelen uyari kutusuna inceleme yapamiyorsak bu tur alert'lere Js alert denir. Bu alert'lere
    mudahale etmek icin asagidaki islemler yapilir.
    => driver.switchTo().alert().accept() : Tamam y ada ok demek icin kullanilir.
    => driver.switchTo().alert().dismiss(): Iptal veya cancel demek icin kullanilir.
    => driver.switchTo().alert().getText(): Alert icindeki mesaji almak icin kullanilir.
    => driver.switchTo().alert().sendKeys("..) : Alert metin kutusu seklinde olursa ve icine bir sey yazmak
       istersek kullanilir.
     */

    /*
    => https://the-internet.herokuapp.com/javascript_alerts adresine gidelim.
    => Click for js Alert butonuna tiklayalim
    = > Tikladiktan sonra cikan uyari mesajina (alert) tamam diyelim
     */

    WebDriver driver;
     @Before
    public void setUp(){
         WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

     }

     @Test
    public void test1() throws InterruptedException {
         // => https://the-internet.herokuapp.com/javascript_alerts adresine gidelim.
         driver.get("https://the-internet.herokuapp.com/javascript_alerts");

          // => Click for js Alert butonuna tiklayalim
         driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

         // = > Tikladiktan sonra cikan uyari mesajina (alert) tamam diyelim
         Thread.sleep(3000);
         driver.switchTo().alert().accept();
     }

     @After
    public void tearDown() throws InterruptedException {
         Thread.sleep(3000);
         driver.close();
     }




}
