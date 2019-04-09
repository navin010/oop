package swingUI.flatFile;

import java.io.BufferedReader;
import java.util.ArrayList;

public class viewer {

    //vars
    static ArrayList<field> fieldArray;

    //constructor
    public viewer(ArrayList<field> fieldArray){
        this.fieldArray = fieldArray;
    }

    //methods
    public String viewFieldsInLine(String filePath, int lineNumber) throws Exception{

        fileReader fileStructureObj = new fileReader(filePath);
        System.out.println("---viewFieldsInLine---");

        String line = fileStructureObj.reader.lines().skip(lineNumber).findFirst().get();           //read line number of value lineNumber
        System.out.println(line);

        String allText = "";
        //loop through field array where f is each field
        for (field f : fieldArray){
            String text = String.format("%s:%s", f.nameOfField, line.substring(f.startPosition, f.endPosition));    //substring the line pull from the file above
            allText += text + "\n";
        }

        System.out.println(allText);
        fileStructureObj.closeFile();
        return allText;

    }


    public String viewFieldsInAllLines(String filePath) throws Exception{

        fileReader fileStructureObj = new fileReader(filePath);

        System.out.println("---viewFieldsInAllLines---");

        String line;
        int linenum = 0;
        String allText = "";

        //Loop through all
        while ((line = fileStructureObj.reader.readLine()) != null){

            linenum++;
            allText += String.format("Line Number %s\n", (linenum));           //add line number heading

            //loop through field array where f is each field
            for (field f : fieldArray){
                String text = String.format("%s:%s", f.nameOfField, line.substring(f.startPosition, f.endPosition));    //substring the line pull from the file above
                allText += text + "\n";
            }

            allText += "\n";        //add crlf separator between lines

        }

        System.out.println(allText);
        fileStructureObj.closeFile();
        return allText;

    }

}
