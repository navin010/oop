package swingUI.flatFile;

import java.io.BufferedReader;
import java.io.FileReader;


public class fileReader {

    public FileReader file;
    public BufferedReader reader;

    //Constructor
    public fileReader(String filePath) throws Exception {
        this.file = new FileReader(filePath);
        this.reader = new BufferedReader(file);
    }

    //Methods
    public void closeFile()throws Exception{
        reader.close();
    }

}
