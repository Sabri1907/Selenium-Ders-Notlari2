package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void test01() throws IOException {
        // Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        // FileInputStream objesi olusturup parametre olarak dosya yolu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        // Workbook objesi olusturup parametre olarak fileInputStream objesini girelim
        //WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        // Turkce baskentler sutununu yazdiralim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        // =>getLastRowNumber(): Excel sayfasinda kac tane satir oldugunu verir.

        System.out.println("sonSatir = " + sonSatir); // 190=> 0'dan basladigi icin 191 satir var
        String turkceBaskentler="";
        int sayac=0;

        for (int i = 0; i <=sonSatir ; i++) {
            turkceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(sayac+": "+turkceBaskentler+" ");
            sayac++;
        }



    }
}
