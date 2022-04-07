package data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVRead {
    String path = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userdata.csv";
    CSVReader reader;

    public  Object[][] readFromCSV() throws IOException, CsvException {
        String [] row;
        reader = new CSVReader(new FileReader(path));
        List<String[]> records= reader.readAll();
        String[][] obj= new String[records.size()][records.get(0).length];
        for(int i = 0 ; i<records.size(); i++)
        {
            obj[i]=records.get(i);
        }
        return obj;
    }

}
