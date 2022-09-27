package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test1() throws IOException {

        // Olusturdugumuz dosyanin yolunu bir string degiskene atayin
        String dosyaYolu="src/resources/ulkeler.xlsx";

        // FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //=> Olusturdugumuz dosyayi FIleInputStream ile sistemde isleme alir.

        // Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim
        // WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        //=> Workbook class'indan fis objesi ile akisa aldigimiz bir excel dosyasi olusturduk

        // Sheet objesi olusturun => workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");
        //=> Excel dosyasinda calismak istedigimiz sayfayi bu sekilde seceriz. getSheetAt(index) ile de yapabiliriz.

        // Row objesi olusturun => sheet.getRow(index)
        Row row=sheet.getRow(3);
        // => Sayfa1'deki 3. satiri secmis olduk

        // Cell objesi olusturun => row.getCell()
        Cell cell=row.getCell(3);
        // Satir secimi yapildiktan sonra hucre secimini de yapmis olduk.
        System.out.println(cell); // Cezayir
        /*
        NOT: Excel index'i 0'dan baslayarak sayar.
         */

        // 3.index'deki satirin 3. index'deki hucrenin Cezayir oldugunu test edin
        String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData,actualData);
        Assert.assertEquals(expectedData,cell.getStringCellValue()); // Cell'in degerine bu sekilde de ulasabiliriz.








    }
}
