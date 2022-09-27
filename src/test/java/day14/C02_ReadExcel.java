package day14;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {
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
        // Row objesi olusturun => sheet.getRow(index)
        // Cell objesi olusturun => row.getCell()

        String actualData=workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();
        // => Calismak istedigimiz sayfa,satir ve hucreyi tek satirda bir string'e atamis olduk.
        // => Bir onceki class'da ayri ayri olusturmustuk.
        System.out.println(actualData); // Ulastigimiz ilgili hucreyi yazdirmis olduk.

    }
}
