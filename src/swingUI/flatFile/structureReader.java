package swingUI.flatFile;

import java.util.ArrayList;


public class structureReader {

    //vars
    static ArrayList<field> fieldArray = new ArrayList<field>();

    //constructor
    public structureReader(){
    }

    //method
    public ArrayList<field> createFieldArray(String filePath) throws Exception{

        clearFieldArray();              //blank the field array otherwise fields are duplicated for sr structureReader reader in main frame

        fileReader fileStructureObj = new fileReader(filePath);

        String line;
        while ((line = fileStructureObj.reader.readLine()) != null) {
            String[] values = line.split(",");
            fieldArray.add(new field(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2])));
        }
        fileStructureObj.closeFile();

        //loop through fields in array and call method show fields on each field
        System.out.println("---viewFieldsInFieldArray---");
        for (field f : fieldArray){
            f.showField();
        }

        return fieldArray;

    }


    public void clearFieldArray(){
        fieldArray = new ArrayList<field>();
    }


}
