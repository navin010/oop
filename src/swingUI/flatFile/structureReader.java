package swingUI.flatFile;

import java.util.ArrayList;


public class structureReader {

    //vars
    static ArrayList<field> fieldArray = new ArrayList<field>();
    static ArrayList<field> fieldArraySingle = new ArrayList<field>();

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


    public ArrayList<field> createFieldArraySingle(String nameOfField, String startPosition, String numberOfChars){

        System.out.println(nameOfField);
        System.out.println(startPosition);
        System.out.println(numberOfChars);


        clearFieldArraySingle();              //blank the field array otherwise fields are duplicated for sr structureReader reader in main frame, can also remove global class vars if desired
        fieldArraySingle.add(new field(nameOfField,Integer.parseInt(startPosition),Integer.parseInt(numberOfChars)));

        return fieldArraySingle;
    }



    public void clearFieldArray(){
        fieldArray = new ArrayList<field>();
    }

    public void clearFieldArraySingle(){
        fieldArraySingle = new ArrayList<field>();
    }

}
