package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://amazon.com sayfasina gidin
        driver.get("https://amazon.com");

        // arama kutusunu locate edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        // "samsung headphones" aratin
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        // Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        System.out.println(sonucYazisi.getText());

        // => Sadece sonuc kismini yazdiralim
        String [] sonucSayisi=driver.findElement
                (By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"))
                .getText().split(" ");
        System.out.println("Samsing Headphone icin Arama Sonuc Sayisi: "+sonucSayisi[2]);
        Thread.sleep(3000);

        // Ilk urunu tiklayin
        WebElement ilkurun= driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        ilkurun.click();

        // Sayfadaki tum basliklari yazdirin
        System.out.println("Basliklar 1: "+driver.findElement(By.xpath("//h1")).getText());
        System.out.println("Basliklar 2: "+driver.findElement(By.xpath("//h2")).getText());
        System.out.println("Basliklar 3: "+driver.findElement(By.xpath("//h3")).getText());
        System.out.println("Basliklar 4: "+driver.findElement(By.xpath("//h4")).getText());
        System.out.println("Basliklar 5: "+driver.findElement(By.xpath("//h5")).getText());
        // System.out.println("Basliklar 6: "+driver.findElement(By.xpath("//h6")).getText());
        // => NosuchElementException verdi



    }
}
