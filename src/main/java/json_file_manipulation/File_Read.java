package json_file_manipulation;

import java.io.FileReader;
import java.io.IOException;


public class File_Read {
    public static void main(String[] args) throws IOException {
        FileReader reader= new FileReader("./src/main/resources/test.txt");
        int character;
        while((character= reader.read())!=-1) {
            System.out.println((char)character);
        }
        reader.close();
    }

}
