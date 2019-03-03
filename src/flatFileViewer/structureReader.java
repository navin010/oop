package flatFileViewer;

import java.util.ArrayList;


public class structureReader {

    //vars
    static ArrayList<field> fieldArray = new ArrayList<field>();

    //constructor
    public structureReader(){
    }

    //method
    public ArrayList<field> createList(String filePath) throws Exception{

        fileReader fileStructureObj = new fileReader(filePath);

        String line;
        while ((line = fileStructureObj.reader.readLine()) != null) {
            String[] values = line.split(",");
            fieldArray.add(new field(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2])));
        }
        fileStructureObj.closeFile();

        //loop through fields in array and call method show fields on each field
        for (field f : fieldArray){
            f.showField();
        }

        return fieldArray;

    }


}
