package swingUI.flatFile;

import java.util.ArrayList;

public class viewer {

    //vars
    static ArrayList<field> fieldArray;

    //constructor
    public viewer(ArrayList<field> fieldArray){
        this.fieldArray = fieldArray;
    }

    //methods
    public void viewFieldsInLine(String filePath, int lineNumber) throws Exception{

        fileReader fileStructureObj = new fileReader(filePath);
        System.out.println("---viewFieldsInLine---");

        String line = fileStructureObj.reader.lines().skip(lineNumber).findFirst().get();           //read line number of value lineNumber
        System.out.println(line);

        //loop through field array where f is each field
        for (field f : fieldArray){
            System.out.println(f.nameOfField + ":" + line.substring(f.startPosition,f.endPosition));
        }

        fileStructureObj.closeFile();

    }

}
