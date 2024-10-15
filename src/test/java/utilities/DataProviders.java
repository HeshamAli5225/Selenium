package utilities;

import data.ExcelReader;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {


    @DataProvider(name = "registration_data")
    public Object [][] registration_data(){
        String [][] arr={
                {"Hesham","ALi","h34@gmail.com","12345678"},
                {"Hesham","ALi","h32@gmail.com","12345678"}
        };
        return new Object[][]{
                {"Hesham","ALi","h34@gmail.com","12345678"},
             //   {"Hesham","ALi","h32@gmail.com","12345678"}
        };
    }

    @DataProvider(name = "excel_data")
    public Object [][] excel_data() throws IOException {
        ExcelReader excelReader=new ExcelReader();
        Object[][] data=excelReader.getExcelData("src/test/java/data/userData.xlsx","Sheet1");
        return data;
    }




}
