package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test1() throws IOException {
        // Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        // FileInputStream objesi olusturup parametre olarak dosya yolu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        // Workbook objesi olusturup parametre olarak fileInputStream objesini girelim
        // WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        // -Excel tablosundaki tum tabloyu konsola yazdiralim
        int satir=workbook.getSheet("sayfa1").getLastRowNum();
        String tablo="";
        for (int i = 0; i <=satir ; i++) {
            tablo=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString()+", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            System.out.println(tablo);

        }
    }
}
