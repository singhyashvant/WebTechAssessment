package Utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVUtils {
    private String filePath;

    public CSVUtils(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> readCSVData() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(filePath));
        List<String[]> data = csvReader.readAll();
        csvReader.close();
        return data;
    }
}

