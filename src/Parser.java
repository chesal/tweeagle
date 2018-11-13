import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
public class Parser {

    public static void main(String[] args) {
        File f=new File("0.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(f);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        String line;
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int count=1;
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonTree=null ;
        try {
            if ((line = bufferedReader.readLine()) != null) {
                jsonTree=jsonParser.parse(line);
            }
            JsonObject jsonObject = jsonTree.getAsJsonObject();
            JsonElement user = jsonObject.get("user");
            JsonElement name=null;
            if(user.isJsonObject()){
                JsonObject f2Obj = user.getAsJsonObject();

                 name = f2Obj.get("name");
            }
            JsonElement text = jsonObject.get("text");
            System.out.println(text+" "+name);
            bufferedReader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
