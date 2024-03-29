package swingUI;

import swingUI.flatFile.field;
import swingUI.flatFile.structureReader;
import swingUI.flatFile.viewer;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.util.ArrayList;

public class mainFrame extends JFrame {

    //vars
    private textPanel tPanel;
    private toolbar tbar;
    private formPanelStructure fPanelStructure;
    private formPanelInput fPanelInput;
    private String globalStructure = "";
    private CardLayout c1;
    private JPanel fPanelJoined;
    private JTabbedPane tabbedPane;

    //constructor
    public mainFrame(){
        super("Flat File Viewer");                       //call JFrame constructor

        try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());               //sets windows look and feel
            UIManager.setLookAndFeel(new NimbusLookAndFeel());                                   //sets windows look and feel
        } catch (Exception e) {
            e.printStackTrace();
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());     //default cross platform UI
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }

        /*
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        */

        setSize(600,500);                       //calling methods from super directly
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit program when gui is closed
        setVisible(true);

        setLayout(new BorderLayout());
        tPanel = new textPanel();
        tbar = new toolbar();
        fPanelStructure = new formPanelStructure();
        fPanelInput = new formPanelInput();

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Input Fields", fPanelInput);
        tabbedPane.addTab("Upload Fields", fPanelStructure);

        /*
        fPanelJoined = new JPanel(new CardLayout());
        fPanelJoined.add(fPanelStructure, "multiPanel");
        fPanelJoined.add(fPanelInput, "singlePanel");
        c1 = (CardLayout) (fPanelJoined.getLayout());

        c1.show(fPanelJoined,"singlePanel");    //multiPanel is shown on startup by default as added to fPanelJoined first, but can be changed here
        */

        add(tabbedPane, BorderLayout.WEST);
        //add(fPanelJoined, BorderLayout.WEST);
        add(tbar, BorderLayout.SOUTH);
        add(tPanel, BorderLayout.CENTER);


        tbar.setStringListener(new stringListener() {
            @Override
            public void textEmitted(String text) {

                if (text == "clear"){
                    //tPanel.appendText(text);
                    tPanel.clearText();
                }
                /*
                else if (text == "multiple"){
                    c1.show(fPanelJoined,"multiPanel");
                }
                else if (text == "single"){
                    c1.show(fPanelJoined,"singlePanel");
                }
                */
            }
        });

        /*
        tbar.setButtonListener(new buttonListener() {
            @Override
            public void buttonPressed() {
                tPanel.clearText();
            }
        });
        */

        fPanelStructure.setFormListener(new formListener() {
            @Override
            public void formEventOccured(formEvent e) {
                System.out.println("Structure Tab");
                String input = e.getInput();
                String structure = e.getStructure();
                String lineNumber = e.getLineNumber();
                String nameOfField = e.getNameOfField();
                try {
                    viewByStructure(input, structure, lineNumber, nameOfField);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        fPanelInput.setFormListener(new formListener() {
            @Override
            public void formEventOccured(formEvent e) {
                System.out.println("inputTab");
                String input = e.getInput();
                String nameOfField = e.getNameOfField();
                String startPosition = e.getStartPosition();
                String numberOfChars = e.getNumberOfChars();
                String lineNumber = e.getLineNumber();
                try {
                    viewByInput(input, nameOfField, startPosition, numberOfChars, lineNumber);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


    }

    //methods
    public void viewByStructure(String input, String structure, String lineNumber, String nameOfField) throws Exception {
        //create field array with multiple field values
        structureReader sr = new structureReader();
        ArrayList<field> fieldArray = sr.createFieldArray(structure, nameOfField);

        //multiple line numbers entered separated by commas
        if (lineNumber.contains(",")) {
            String[] values = lineNumber.split(",");
            for (String s: values) {
                viewData(fieldArray, input, s);
            }
        }
        //single line number entered
        else {
            viewData(fieldArray, input, lineNumber);
        }
    }

    public void viewByInput(String input, String nameOfField, String startPosition, String numberOfChars, String lineNumber) throws Exception {
        //create field array with single field value
        structureReader sr = new structureReader();
        //ArrayList<field> fieldArray = sr.createFieldArraySingle(nameOfField, startPosition, numberOfChars);
        ArrayList<field> fieldArray = new ArrayList<field>();

        //check multiple fields entered separated by commas, generate field array for multiple values
        if (nameOfField.contains(",") || startPosition.contains(",") || numberOfChars.contains(",")) {
            System.out.println("field contains comma");

            String[] nameOfFieldValues = nameOfField.split(",");
            String[] startPositionValues = startPosition.split(",");
            String[] numberOfCharsValues = numberOfChars.split(",");

            int arrayLength = nameOfFieldValues.length;
            for (int i=0; i<arrayLength; i++)
            {
                String nameOfFieldVal = nameOfFieldValues[i];
                String startPositionVal = startPositionValues[i];
                String numberOfCharsVal = numberOfCharsValues[i];

                System.out.println("Array Length " + arrayLength);
                System.out.println(nameOfFieldVal + ":" + startPositionVal + ":" + numberOfCharsVal);
                fieldArray.add(new field(nameOfFieldVal,Integer.parseInt(startPositionVal),Integer.parseInt(numberOfCharsVal)));
            }
        }
        //otherwise generate single field for field array
        else {
            fieldArray = sr.createFieldArraySingle(nameOfField, startPosition, numberOfChars);
        }


        //multiple line numbers entered separated by commas
        if (lineNumber.contains(",")) {
            String[] values = lineNumber.split(",");
            for (String s: values) {
                viewData(fieldArray, input, s);
            }
        }
        //single line number entered
        else {
            viewData(fieldArray, input, lineNumber);
        }
    }

    //common method to view data
    public void viewData(ArrayList<field> fieldArray, String input, String lineNumber) throws Exception {

        //Generate viewer object and return concatenated string
        viewer v = new viewer(fieldArray);
        String allText;

        //if line number is empty
        if (lineNumber.isEmpty()){
            allText = v.viewFieldsInAllLines(input);
        }

        //if line number is not empty
        else {
            //line number formatting, convert to int. Minus 1 as java arrays start from 0 and lines in editors start from 1
            int lineNumberInt = Integer.parseInt(lineNumber);
            lineNumberInt = lineNumberInt - 1;
            allText = v.viewFieldsInLine(input, lineNumberInt);
            allText = String.format("Line Number %s\n%s\n", (lineNumber), allText);    //wrap output in header/footer
        }

        //Append to text panel
        tPanel.appendText(allText);

    }




}
