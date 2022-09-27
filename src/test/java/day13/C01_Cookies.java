package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // Amazon sayfasina gidin
        driver.get("https://www.amazon.com");

        // tum cookie'leri listeleyin
        Set<Cookie> tumCookie=driver.manage().getCookies();
        //=> getCookies() methoduyla tum cookies ile Cookie class'indan set olusturup icine attik.
        System.out.println(tumCookie);

        int sayac=1;
        for (Cookie each: tumCookie) {
            System.out.println(sayac+"'inci Cookie: "+each);
            System.out.println(sayac+"'inci Name: "+each.getName());
            System.out.println(sayac+"'inci Value: "+each.getValue());
            sayac++;

        }
        System.out.println("********************************************");
        // Sayfadaki cookies sayisinin 5'den buyuk oldugunu test edin
        int cookieSayisi=tumCookie.size();
        Assert.assertTrue(cookieSayisi>5);

        // Ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each: tumCookie) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
            }
        }

        // Ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        // => Cookie class'indan yeni cookie olusturduk.
        driver.manage().addCookie(yeniCookie);
        tumCookie=driver.manage().getCookies();

        sayac=1;
        for (Cookie each: tumCookie) {
            System.out.println(sayac+"'inci Cookie: "+each);
            System.out.println(sayac+"'inci Name: "+each.getName());
            System.out.println(sayac+"'inci Value: "+each.getValue());
            sayac++;
        }
        System.out.println("********************************************");
        // Ekledigimiz cookie'nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookie.contains(yeniCookie));

        // Ismi "skin" olan cookie'yi silin ve silindigini kontrol edin
        driver.manage().deleteCookieNamed("skin");

        tumCookie=driver.manage().getCookies();

        sayac=1;
        for (Cookie each: tumCookie) {
            System.out.println(sayac+"'inci Cookie: "+each);
            System.out.println(sayac+"'inci Name: "+each.getName());
            System.out.println(sayac+"'inci Value: "+each.getValue());
            sayac++;
        }

        Cookie isim=driver.manage().getCookieNamed("skin");
        Assert.assertFalse(tumCookie.contains(isim));


        // Tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookie=driver.manage().getCookies();
        Assert.assertTrue(tumCookie.isEmpty());

    }
}
