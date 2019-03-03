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
    public void closeFile()throws Exception{
        reader.close();
    }

}
