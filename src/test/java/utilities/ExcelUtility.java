package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);
        int rowcount = sheet.getLastRowNum();
        wb.close();
        fis.close();
        return rowcount;
    }

    public int getCellCount(String sheetName, int rownum) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);
        Row row = sheet.getRow(rownum);
        int cellcount = row.getLastCellNum();
        wb.close();
        fis.close();
        return cellcount;
    }

    public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetName);
        Row row = sheet.getRow(rownum);
        Cell cell = row.getCell(colnum);

        DataFormatter formatter = new DataFormatter();
        String data = formatter.formatCellValue(cell);

        wb.close();
        fis.close();
        return data;
    }
}
