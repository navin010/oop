package flatFileViewer;

public class tester {

    public static void main(String[] args) throws Exception {

        structureReader sr = new structureReader();

        structureViewer sv = new structureViewer(sr.createList("C:/Java/OOP/src/flatFileViewer/structure.txt"));
        sv.viewList("C:/Java/OOP/src/flatFileViewer/input.txt", 0);

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
