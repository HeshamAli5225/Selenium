package data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {


    public FileInputStream getFileInputStream(String path){
        FileInputStream fis = null;
        File file=new File(path);
        try {
            fis=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
            System.out.println("CheckFilePath");
        }
        return fis;
    }

    @Test
    public Object[][]  getExcelData(String filePath,String sheetName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(getFileInputStream(filePath));
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int number_of_rows = sheet.getLastRowNum();//get numbers of rows without header
        int number_of_columns = sheet.getRow(0).getLastCellNum();//get numbers of columns
        //System.out.println(number_of_rows+","+number_of_columns);
        String[][] data = new String[number_of_rows][number_of_columns];
        for (int i = 0; i < number_of_rows; i++) {
            for (int k = 0; k < number_of_columns; k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }

        }
        workbook.close();
        return data;
    }

}
