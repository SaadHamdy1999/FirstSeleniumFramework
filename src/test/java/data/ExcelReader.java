package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
   static FileInputStream stream=null;

    public FileInputStream getFileInputStream()
    {
        String path = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userdata.xlsx";
        File src = new File(path);
        try {
            stream = new FileInputStream(src);
        }
        catch (FileNotFoundException e){
            System.out.println("Error Occurred"+ e.getMessage());
        }
        return stream;

    }
    public Object[][] getExcelData() throws IOException {
        int totalNumberOfColumns;
        int totalNumberOfRows;
        stream=getFileInputStream();

            XSSFWorkbook workBook = new XSSFWorkbook(stream);
            XSSFSheet workSheet = workBook.getSheetAt(0);
            totalNumberOfRows = workSheet.getLastRowNum()+1  ;
            totalNumberOfColumns = 5;
            String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfColumns];
            for(int i=0; i<totalNumberOfRows;i++)
            {
                XSSFRow row = workSheet.getRow(i);
                for(int j=0; j<totalNumberOfColumns; j++)
                {
                    arrayExcelData[i][j]=row.getCell(j).toString();
                }
            }
            workBook.close();
            return arrayExcelData;

    }
}
