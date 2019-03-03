package flatFileViewer;
import java.io.BufferedReader;  //scanner to read file
import java.io.FileReader;      //access file system


public class fileReader {

    public FileReader file;
    public BufferedReader reader;
    public String[] lineValues;

    //Constructor
    public fileReader(String filePath) throws Exception {
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

    public void readFileWithKeys(field Field) throws Exception{
        System.out.println("---read with fields---");
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            System.out.println(Field.nameOfField + ":" + line.substring(Field.startPosition,Field.endPosition));
        }
    }


    public void readCsvFile(String delimiter) throws Exception{

        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(delimiter);
            System.out.println(values[0]);
            System.out.println(values[1]);
            System.out.println(values[2]);

        }
    }

    public void closeFile()throws Exception{
        reader.close();
    }


}
