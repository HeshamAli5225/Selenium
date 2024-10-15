package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {


    public static Properties userData=loadProperties("src/main/java/properties/userData.properties");

    private static Properties loadProperties(String path){
        Properties pro=new Properties();
        try {
            //File file= new File(path);
            FileInputStream stream=new FileInputStream(path);
            pro.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pro;
    }



}
