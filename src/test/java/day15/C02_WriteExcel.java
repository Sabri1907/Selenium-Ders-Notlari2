package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void test1() throws IOException {
        // Adimlari takip ederek 1. satira kadar gidelim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        // 5. hucreye yeni bir cell olusturalim ve olusturdugumuz hucreye nufus yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        // 2.satir nufus kolonuna 1500000 yazdirin
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("150000");

        // 10.satir nufus kolnuna 250000 yazdirin
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");

        // 15.satir nufus kolnuna 54000 yazdirin
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("250000");

        // Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        /*
        => NOT: Dosyayi kaydetmeden yukarida yaptigimiz islemler gerceklesmez.
            Excel dosyamiza veri girisi yaptiktan sonra dosyayi akisa aldigimiz gibi sonlandirmamiz gerekir.
            Sonrasinda da workbook objemize kayit etmemiz gerekir.
         */

        workbook.write(fos);
        // => write methodunu kullanarak FileOutputStream ile sonlandirdigimiz islemi workbook'a yazdirdik.

        // Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();

        //********************************* => ONEMLI NOT <= **************************************************
        /*
            Eger bilgisayarimizda bir excel dosyasinda degisiklik yapmak istersek olusturdugumuz
         string dosya yoluna bilgisayardaki excxel'in dosya yolunu atariz. Degisiklikleri kaydetmekl icin
         yine o dosyayi da kapatmamiz gerekir.

        */




    }
}
