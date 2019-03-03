package flatFileViewer;

public class tester {

    public static void main(String[] args) throws Exception {

        field field1 = new field("BEP",0, 5);
        field1.showField();
        field field2 = new field("DOS",6, 5);
        field2.showField();
        field field3 = new field("JEL",12, 3);
        field3.showField();

        fileReader inputFileObject = new fileReader("C:/Java/OOP/src/flatFileViewer/input.txt");
        //inputFileObject.readFile();
        inputFileObject.readFileWithKeys(field1);
        inputFileObject.closeFile();

        structureReader sr = new structureReader();
        sr.createList();


        /*
        fileWriter fileWriterObj = new fileWriter("C:/Java/OOP/src/flatFileViewer/output.txt");
        fileWriterObj.writeToFile("hello output");
        fileWriterObj.closeFile();
        */

        /*
        fileReader inputFileObject2 = new fileReader("C:/Java/OOP/src/flatFileViewer/structure.txt");
        inputFileObject2.readCsvFile(",");
        */

    }

}
