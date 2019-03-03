package flatFileViewer;

import java.io.BufferedReader;  //scanner to read file
import java.io.FileReader;      //access file system


public class fileReader {

    public FileReader file;
    public BufferedReader reader;

    //Constructor
    public fileReader(String filePath) throws Exception {
        this.file = new FileReader(filePath);
        this.reader = new BufferedReader(file);
    }

    //Methods
    public void readFile() throws Exception{

        String text = "";
        String line = reader.readLine();    //read line ba line


        while (line != null){
            text += line;
            line = reader.readLine();
        }

        reader.close();                     //close file so can be opened by another program
        System.out.println(text);
        System.out.println(text.substring(0,5));
        System.out.println(text.substring(6,11));
        System.out.println(text.substring(12,15));
    }


}
