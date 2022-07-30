package json_file_manipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Json_Manipulation {
    public static void main(String[] args) throws IOException, ParseException {
        //jsonWrite();
        //
        // readJSONFile();
//        writeJSONList();
//        readStudentArraylist(2);
//        updateEmployeeJSON("Deparment", "EEE");
//        updateListStudent(1,"name","asif");
        deleteStudent(1);

    }

    private static void jsonWrite() throws IOException {
        JSONObject empObj = new JSONObject();
        empObj.put("Name", "Imran Sarker");
        empObj.put("Deparment", "CSE");
        empObj.put("Designation", "Sofware Engineer");
//        empObj.put("Address","Dhaka");

        JSONObject adressObj = new JSONObject();
        adressObj.put("preaent_address", "nasirabad, Chittagong");
        adressObj.put("po", "PTI");
        adressObj.put("area", "Chittagong");
        empObj.put("address", adressObj);

        // convert to json file
        FileWriter file = new FileWriter("./src/main/resources/employee.json");
        file.write(empObj.toJSONString()); // empobj k json hisebe write kore
        // saving the file
        file.flush();

        System.out.println(empObj);


    }

    //@SuppressWarnings("unchecked")
    private static void readJSONFile() throws IOException, ParseException {
        /* for read e json file , json file k object e convert kore thn objet hisebe file ta read korbe */

        JSONParser jsonParser = new JSONParser(); //creating a constructor named jsonparser
        Object obj = jsonParser.parse(new FileReader("./src/main/resources/employee.json")); // find the location nd thn return the json
        //file which will be parsed by parse method and assigned in an obj variable
        JSONObject empObj = (JSONObject) obj; //casting the obj variable with JSONobject. and coverting the normal object to json object

        System.out.println(empObj);
        String name = (String) empObj.get("Name");
        System.out.println(name);
        String department = (String) empObj.get("Deparment");
        System.out.println(department);
        String designation = (String) empObj.get("Designation");
        System.out.println(designation);

        JSONObject addressObj = (JSONObject) empObj.get("address");
        String area = (String) addressObj.get("area");
        System.out.println(area);
        String po = (String) addressObj.get("po");
        System.out.println(po);

        String present_add = (String) addressObj.get("preaent_address");
        System.out.println(present_add);

    }


    /// create json array list
    private static void writeJSONList() throws IOException, ParseException {
        char ch = 'y';
        String fileName = "./src/main/resources/student.json";
        do {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONObject studentObj = new JSONObject();

            //creating the objects---
            Scanner input = new Scanner(System.in);
            System.out.println("Input student ID: ");
            studentObj.put("id", input.next());
            System.out.println("Input student name: ");
            studentObj.put("name", input.next());
            System.out.println("Input Department ");
            studentObj.put("department", input.next());

            // converting single object into array
            JSONArray jsonStudentArray = (JSONArray) obj;
            //adding the objects into jsonarray list
            jsonStudentArray.add(studentObj);
            System.out.print(jsonStudentArray);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonStudentArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved!");
            System.out.print(jsonStudentArray);
            System.out.println("\nDo you want to add more?[y/n]");

            ch = input.next().charAt(0);

        }
        while (ch != 'n');

    }

    private static void readStudentArraylist(int pos) throws IOException, ParseException {
        //int pos=0;

        String fileName = "./src/main/resources/student.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        //System.out.println(jsonArray);
        //fetch the data from specific index/position
        JSONObject jsonObject = (JSONObject) jsonArray.get(pos);

        String name = (String) jsonObject.get("name");
        String id = (String) jsonObject.get("id");
        String department = (String) jsonObject.get("department");
        System.out.println(name);
        System.out.println(id);
        System.out.println(department);


    }

    private static void updateEmployeeJSON(String key, String value) throws IOException, ParseException {
        String fileName = "./src/main/resources/employee.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONObject empObj = (JSONObject) obj;

        System.out.println(empObj);
        empObj.put(key, value);
        FileWriter file = new FileWriter(fileName);
        file.write(empObj.toJSONString());
        file.flush();


    }

    private static void updateListStudent(int index, String key, String value) throws IOException, ParseException {
        String fileName="./src/main/resources/student.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject jsonObject = (JSONObject) jsonArray.get(index);
        jsonObject.put(key, value);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("Updated!");
        System.out.print(jsonArray);
    }
    private static void deleteStudent(int index) throws IOException, ParseException {
        String fileName="./src/main/resources/student.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        jsonArray.remove(index);
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
        System.out.println("Deleted!");
        System.out.print(jsonArray);
    }


}



//for formatting json data: cntrl+alt+L