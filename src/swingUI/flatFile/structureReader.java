package swingUI.flatFile;

import java.util.ArrayList;


public class structureReader {

    //vars
    static ArrayList<field> fieldArray = new ArrayList<field>();
    static ArrayList<field> fieldArraySingle = new ArrayList<field>();

    //constructor
    public structureReader(){
    }

    //methods
    public ArrayList<field> createFieldArray(String filePath, String nameOfField) throws Exception{

        clearFieldArray();              //blank the field array otherwise fields are duplicated for sr structureReader reader in main frame

        fileReader fileStructureObj = new fileReader(filePath);

        String line;
        while ((line = fileStructureObj.reader.readLine()) != null) {
            String[] values = line.split(",");                              //split line values by comma

            //multiple field names entered separated by commas
            if (nameOfField.contains(",")) {
                String[] fieldNames = nameOfField.split(",");                //split name of field values
                //loop through field names array
                for (String f: fieldNames) {
                    if (values[0].equals(f)) {
                        fieldArray.add(new field(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2])));
                    }
                }
            }

            //no field name entered
            else if (nameOfField.isEmpty()){
                fieldArray.add(new field(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2])));
            }

            //single field name entered
            else {
                if (values[0].equals(nameOfField)) {
                    fieldArray.add(new field(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2])));
                }
            }


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
