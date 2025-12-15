package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class Dataproviders {

    @DataProvider(name = "loginData")
    public String[][] getData() throws IOException {

        String path = ".\\testdata\\testdataopencart.xlsx";
        ExcelUtility xlutil = new ExcelUtility(path);

        int totalrows = xlutil.getRowCount("sheet1");
        int totalcellcount = xlutil.getCellCount("sheet1", 1);

        String loginData[][] = new String[totalrows][totalcellcount];

        for (int i = 1; i <= totalrows; i++) {
            for (int j = 0; j < totalcellcount; j++) {
                loginData[i - 1][j] = xlutil.getCellData("sheet1", i, j);
            }
        }
        return loginData;
    }
}
