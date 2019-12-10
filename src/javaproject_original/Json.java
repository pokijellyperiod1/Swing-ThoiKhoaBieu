package javaproject_original;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json {

   
    
    @SuppressWarnings("unchecked")
    public static void writeJsonSimpleDemon(String fileName ,Map<String, DanhSachItems_Model> tableContent) throws IOException {

        
        System.out.println("Ghi File");
		
        JsonObject jsonObject = new JsonObject();
        JsonObject obj = new JsonObject();
        JSONObject result = new JSONObject();
        FileWriter file = new FileWriter(fileName);

       
            DanhSachItems_Model ds = new DanhSachItems_Model();
            
            obj = new JsonObject();
            
            JSONArray jSONArray = new JSONArray();
            for (String k : tableContent.keySet()) {
                int i = 0;
//                System.out.println("Lan thu " + i + ", key: " + k);
                 
                 obj = new JsonObject();
                 jsonObject = new JsonObject();
                 obj.put("Id", tableContent.get(k).getId());
                 obj.put("Row", tableContent.get(k).getRow());
                 obj.put("Column", tableContent.get(k).getColum());
                 obj.put("Content", tableContent.get(k).getContent());
//                 System.out.println("Content in Json: " + tableContent.get(k).getContent());
                 
                 result.put(k, obj);
//                 
                
                 
        }
            
            
            
                
//             for (String key : tableContent.keySet()) {
//                     System.out.println("Key int Json: " + key + " value: " + tableContent.get(key).getContent());
//            
//             }
        
            
           

        
//             System.out.println("JsonArray: " + jSONArray.toJSONString());
//             
//             System.out.println("Result: " + result.toJSONString());
//        
//             System.out.println("Json: " +jsonObject.toJson());
             
             
        
             try {
             
                   file.write(result.toJSONString());
                   file.flush();
                   System.out.println("Thanh Cong");
                   
            } catch (Exception e) {
                System.out.println("Loi ghi file");
            }
             
             
        
        
        

    }

    public static Map<String, DanhSachItems_Model> readJsonSimpleDemon(String fileName){

        System.out.println("Read File");
        
        List<DanhSachItems_Model> listItems_Models = new ArrayList<DanhSachItems_Model>();

        JSONParser parser = new JSONParser();
        JSONObject obj = new JSONObject();
        Map<String, DanhSachItems_Model> result = new HashMap<String, DanhSachItems_Model>();

        try (Reader reader = new FileReader(fileName)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
//            System.out.println(jsonObject);
            
            
            for (int i = 0; i < 10; i++) {
                
                for (int j = 0; j < 7; j++) {
                    
                    String key = String.valueOf(i) + String.valueOf(j);
                    
                    JSONObject msg = (JSONObject) jsonObject.get(key);
                    
                    
                    

                    DanhSachItems_Model ds = new DanhSachItems_Model();

                    ds.setColum((long) msg.get("Column"));
                    ds.setContent(String.valueOf(msg.get("Content")));
                    ds.setId(String.valueOf(msg.get("Id")));
                    ds.setRow((long) msg.get("Row"));
                    

                    result.put(key, ds);
                    
                }
                
                
            }
            
            
//            System.out.println("Result:");
//            for (String rs : result.keySet()) {
//                System.out.println(rs + "\t" + result.get(rs).getContent());
//            }
            
            System.out.println("Thanh Cong");
            

        } catch (Exception e) {
//            File file = new File(fileName);
//            
//            readJsonSimpleDemon(fileName);
            System.out.println("Exception");
        }

        return result;
        

    }

    public void getOject(JSONObject obj) {

    }

//    public static void main(String[] args) throws ParseException, IOException {
//
//        
//        readJsonSimpleDemon("test.json");
//
//    }

}
