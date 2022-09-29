package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {
    @Test
    public void deleteExcelCell() throws IOException {
        // Olusturdugumuz dosyanin yolunu bir string degiskene atayin
        String dosyaYolu="src/resources/ulkeler.xlsx";

        // FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        // Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim
        // WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        // Sheet objesi olusturun => workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");

        // Row objesi olusturun => sheet.getRow(index)
        Row row=sheet.getRow(3);

        // Cell objesi olusturun => row.getCell()
        Cell cell=row.getCell(3);
        System.out.println(cell); // Cezayir

        // 3.satir 3.cell'deki veriyi silin
        // =>NOT: Bir cell'deki veriyi silmek icin row objesine ihtiyac vardir.
        // Row objesi ile birlikte removeCell() methodunu kullanarak silmek istedigimiz cell objesini method
        // parantezine yazarak sileriz.
        row.removeCell(cell);
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        // Istenen cell'deki verinin soilindigini test edin
        String expectedData="Cezayir";
        String actualData=workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();
        Assert.assertNotEquals(expectedData,actualData);


    }
}
