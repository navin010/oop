package flatFileViewer;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class fileWriter {

    public File newFile;
    public FileWriter newFileWriter;
    public BufferedWriter newBufferedWriter;

    //Constructor
    public fileWriter(String filePath){
        this.newFile = new File(filePath);
        if (newFile.exists()){
            System.out.println("file exists");
        }
        else {
            try {
                newFile.createNewFile();
            }
           catch (Exception e){
                e.printStackTrace();
           }
           try{
               this.newFileWriter = new FileWriter(newFile);
               this.newBufferedWriter = new BufferedWriter(newFileWriter);
           }
           catch (Exception e){
               e.printStackTrace();
           }
        }

    }

    //Methods
    public void writeToFile(String s) throws Exception{
        newBufferedWriter.write(s);
    }

    public void closeFile() throws Exception{
        newBufferedWriter.close();
    }

}
