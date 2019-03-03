package flatFileViewer;

import java.util.ArrayList;

public class structureViewer {

    //vars
    static ArrayList<field> fieldArray;

    //constructor
    public structureViewer(ArrayList<field> fieldArray){
        this.fieldArray = fieldArray;
    }

    //methods
    public void viewList(String filePath, int lineNumber) throws Exception{

        fileReader fileStructureObj = new fileReader(filePath);
        System.out.println("---read with fields---");

        String line = fileStructureObj.reader.lines().skip(lineNumber).findFirst().get();           //read line number of value lineNumber
        System.out.println(line);

        for (field f : fieldArray){
            System.out.println(f.nameOfField + ":" + line.substring(f.startPosition,f.endPosition));
        }

        fileStructureObj.closeFile();

    }

}
