package flatFileViewer;

import java.util.ArrayList;
import java.util.Scanner;


public class structureReader {

    //vars
    static ArrayList<field> fieldArray = new ArrayList<field>();

    //constructor
    public structureReader(){
    }

    //method
    public void createList() throws Exception{

        fileReader fileStructureObj = new fileReader("C:/Java/OOP/src/flatFileViewer/structure.txt");

        String line;
        while ((line = fileStructureObj.reader.readLine()) != null) {
            String[] values = line.split(",");
            fieldArray.add(new field(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2])));
        }
        fileStructureObj.closeFile();

        for (field f : fieldArray){
            f.showField();
        }


    }


}
