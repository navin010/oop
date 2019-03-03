package flatFileViewer;

public class tester {

    public static void main(String[] args) throws Exception {

        fileReader inputFileObject = new fileReader("C:/Java/OOP/src/flatFileViewer/input.txt");
        inputFileObject.readFile();

        /*
        fileWriter fileWriterObj = new fileWriter("C:/Java/OOP/src/flatFileViewer/output.txt");
        fileWriterObj.writeToFile("hello output");
        fileWriterObj.closeFile();
        */

        field field1 = new field("BEP",0, 5);
        field1.showField();
        field field2 = new field("DOS",6, 5);
        field2.showField();
        field field3 = new field("JEL",12, 3);
        field3.showField();

    }

}
