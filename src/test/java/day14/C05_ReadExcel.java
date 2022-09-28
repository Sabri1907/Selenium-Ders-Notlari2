package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void test1() throws IOException {
        // Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        // FileInputStream objesi olusturup parametre olarak dosya yolu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        // Workbook objesi olusturup parametre olarak fileInputStream objesini girelim
        // WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        // Sayfa2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
        int actualSatirSayisi=workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println("actualSatirSayisi = " + actualSatirSayisi);
        int expectedSatirSayisi=6;
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi+1);
        // => Saymaya 0'dan basladigi icin kontrol ederken actualsatirsayisi'ni +1 yaptik

       int kullanilanSatir=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
       // => getPhysicalNumberOfRows() excel tablosunda kullanilan satir sayisini verir.
        System.out.println("kullanilanSatir = " + kullanilanSatir);

        int expectedKullanilanSatir=3;
        Assert.assertEquals(expectedKullanilanSatir,kullanilanSatir);
        // =>NOT: getPhysicalNumberOfRows()methodunda Kullanilan satir sayisini saymaya 1'den baslar o yuzden
        // kontrol ederken +1 demedik.


    }
}
