package flatFileViewer;

import java.io.BufferedReader;
import java.io.FileReader;


public class oldFileReader {

    public FileReader file;
    public BufferedReader reader;
    public String[] lineValues;

    //Constructor
    public oldFileReader(String filePath) throws Exception {
        this.file = new FileReader(filePath);
        this.reader = new BufferedReader(file);
    }

    //Methods
    public void readFile() throws Exception{
        String text = "";
        String line = reader.readLine();    //read line by line
        while (line != null){
            text += line;
            line = reader.readLine();
        }
        System.out.println(text);
    }

    public void readFileWithKey(field Field) throws Exception{
        System.out.println("---read with fields---");
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            System.out.println(Field.nameOfField + ":" + line.substring(Field.startPosition,Field.endPosition));
        }
    }


    public void closeFile()throws Exception{
        reader.close();
    }


}
