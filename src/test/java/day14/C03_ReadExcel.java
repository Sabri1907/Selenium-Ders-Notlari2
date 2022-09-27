package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void test1() throws IOException {

      //Belirtilen satirNo ve SutunNo degerlerini parametre olarak alip ilgili cell'deki
      // datayi konsola yazdiralim.
            int satirNo=12;
            int sutunNo=2;

      String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        String actualData=workbook.getSheet("sayfa1").getRow(satirNo-1).getCell(sutunNo-1).toString();
        // => Excel'de index 0'dan basladigi icin satir ve sutunu-1 yaptik
        System.out.println(actualData);



     // Sonucun konsolda yazanla ayni oldugunu dogrulayin

    }
}
