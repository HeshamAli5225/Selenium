package data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonDataReader {

    public String firstName;
    public String lastName;
    public String email;
    public String password;


    public void jsonReader() throws FileNotFoundException {
        File file=new File("src/test/java/data/userData.json");
        JsonParser parser=new JsonParser();
        JsonArray jsonArray= (JsonArray) parser.parse(new FileReader(file));

        for (Object item:jsonArray) {
            JsonObject user=(JsonObject) item;
            firstName= user.get("firstName").getAsString();
            lastName= user.get("lastName").getAsString();
            email= user.get("email").getAsString();
            password= user.get("password").getAsString();
            System.out.println(firstName+":"+lastName+":"+email+":"+password);

        }

    }

}
