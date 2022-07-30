package json_file_manipulation;

import java.io.FileWriter;
import java.io.IOException;


public class File_Write {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter= new FileWriter("./src/main/resources/test.txt",true); // every time output will be added to previous using true
        fileWriter.write("Hello World");
        //fileWriter.write("\n");

        fileWriter.close();

    }

}
