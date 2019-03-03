package flatFileViewer;

public class tester {

    public static void main(String[] args) throws Exception {

        structureReader sr = new structureReader();
        viewer v = new viewer(sr.createFieldArray("C:/Java/OOP/src/flatFileViewer/structure.txt"));
        v.viewFieldsInLine("C:/Java/OOP/src/flatFileViewer/input.txt", 1);

    }

}
