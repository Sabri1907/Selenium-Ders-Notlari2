package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExist {

    /*

        Bir web sayfasindan indirdigimiz ya da windows icinde olusturdugumuz dosyanin indigini ya da orda oldugunu
    test edebilmemiz icin o dosyanin uzerine shift tusuna basili olarak sag click yapip dosyanin yolunu
    kopyalayip bir string degiskene atariz ve dosyayi asagidaki method'la dogrulariz.
    => Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    => System.out.println(Files.exists(Paths.get(dosyaYolu))); // True veya false dondurur.
    ==============================================>NOT<====================================================
        Selenium'la bilgisayara ulasamadigimiz icin bilgisayardaki dosyayi Java ile kontrol editoruz.



     */
    @Test
    public void test1() {
        System.out.println(System.getProperty("user.dir")); //C:\Users\dell\IdeaProjects\com.Batch81JUnit
        // Su anki icinde bulundugum yolu gosterir

        System.out.println(System.getProperty("user.home")); // C:\Users\dell
        // Gecerli kullanicinin ana dizinini verir.

        /*
        1.YONTEM (UZUN YOL)


        String farkliBolum= System.getProperty("user.home");
        //"C:\Users\dell\Desktop\text.txt.txt" => Masa ustundeki dosyanin yolu

        String ortakBolum= "Desktop\\text.txt.txt";

        String masaUstuDosyaYolu=farkliBolum+ortakBolum;
        //=> Masaustundeki dosya yolunu gosterir.

        System.out.println(masaUstuDosyaYolu);

        System.out.println(Files.exists(Path.of(masaUstuDosyaYolu)));
        Assert.assertTrue(Files.exists(Path.of(masaUstuDosyaYolu)));
        */
        // 2. YONTEM (KISA & PRATIK YONTEM)
        String dosyaYolu="C:\\Users\\dell\\Desktop\\text.txt.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
