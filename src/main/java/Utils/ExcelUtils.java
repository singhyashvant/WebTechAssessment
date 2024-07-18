package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private String filePath;

    public ExcelUtils(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> readExcelData(String sheetName) throws IOException {
        List<String[]> data = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        for (Row row : sheet) {
            int cellCount = row.getLastCellNum();
            String[] rowData = new String[cellCount];
            for (int i = 0; i < cellCount; i++) {
                Cell cell = row.getCell(i);
                rowData[i] = cell.toString();
            }
            data.add(rowData);
        }
        workbook.close();
        return data;
    }
}

