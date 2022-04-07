package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class JsonDataReader {
    String path= System.getProperty("user.dir")+"\\src\\test\\java\\data\\userdata.json";

    public Object[][] JsonRead() throws IOException, ParseException {
        File src = new File(path);
        JSONParser parser =new JSONParser();
        JSONArray jarray= (JSONArray) parser.parse(new FileReader(src));
        Object [][] arr= new Object[1][1];
        var values = new ArrayList<String>();
        for(int i=0; i< jarray.size();i++)
        {
            System.out.println(jarray.size());
            values = new ArrayList<String>();
            JSONObject object = (JSONObject) jarray.get(i);
            for(Object key : object.keySet()){
               String val= (String) object.get(key);
               values.add(val);
               System.out.println(val);
            }
            if(i== 0) {
                System.out.println("awd");
                arr = new Object[jarray.size()][object.keySet().size()];
            }

            arr[i]=values.toArray();
            System.out.println("sawd");

        }
    return arr;
    }
}
