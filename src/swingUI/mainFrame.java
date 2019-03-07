package swingUI;

import swingUI.flatFile.field;
import swingUI.flatFile.structureReader;
import swingUI.flatFile.viewer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class mainFrame extends JFrame {

    //vars
    private textPanel tPanel;
    private toolbar tbar;
    private formPanel fPanelMultiple;
    private formPanelSingleFieldSearch fPanelSingle;
    private String globalStructure = "";
    //static ArrayList<field> fieldArray = new ArrayList<field>();
    private CardLayout c1;
    private JPanel fPanelJoined;

    //constructor
    public mainFrame(){
        super("FF Viewer");                             //call JFrame constructor
        setSize(600,500);                       //calling methods from super directly
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit program when gui is closed
        setVisible(true);

        setLayout(new BorderLayout());
        tPanel = new textPanel();
        tbar = new toolbar();
        fPanelMultiple = new formPanel();
        fPanelSingle = new formPanelSingleFieldSearch();

        fPanelJoined = new JPanel(new CardLayout());
        fPanelJoined.add(fPanelMultiple, "multiPanel");
        fPanelJoined.add(fPanelSingle, "singlePanel");
        c1 = (CardLayout) (fPanelJoined.getLayout());

        c1.show(fPanelJoined,"multiPanel");    //multiPanel is shown on startup by default as added to fPanelJoined first, but can be changed here

        add(fPanelJoined, BorderLayout.WEST);
        add(tbar, BorderLayout.SOUTH);
        add(tPanel, BorderLayout.CENTER);


        tbar.setStringListener(new stringListener() {
            @Override
            public void textEmitted(String text) {

                if (text == "clear"){
                    //tPanel.appendText(text);
                    tPanel.clearText();
                }
                else if (text == "multiple"){
                    c1.show(fPanelJoined,"multiPanel");
                }
                else if (text == "single"){
                    c1.show(fPanelJoined,"singlePanel");
                }

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

        fPanelMultiple.setFormListener(new formListener() {
            @Override
            public void formEventOccured(formEvent e) {
                System.out.println("multi");
                String input = e.getInput();
                String structure = e.getStructure();
                String lineNumber = e.getLineNumber();

                try {
                    viewFieldsOnLine(input, structure, lineNumber);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        fPanelSingle.setFormListener(new formListener() {
            @Override
            public void formEventOccured(formEvent e) {
                System.out.println("single");
                String input = e.getInput();
                String nameOfField = e.getNameOfField();
                String startPosition = e.getStartPosition();
                String numberOfChars = e.getNumberOfChars();
                String lineNumber = e.getLineNumber();
                try {
                    viewFieldsOnLineSingle(input, nameOfField, startPosition, numberOfChars, lineNumber);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


    }

    //methods
    public void viewFieldsOnLine(String input, String structure, String lineNumber) throws Exception {

        structureReader sr = new structureReader();
        ArrayList<field> fieldArray = sr.createFieldArray(structure);

        //line number formatting, convert to int. Minus 1 as java arrays start from 0 and lines in editors start from 1
        int lineNumberInt = Integer.parseInt(lineNumber);
        lineNumberInt = lineNumberInt - 1;

        //Generate viewer object and return concatenated string
        viewer v = new viewer(fieldArray);
        String allText = v.viewFieldsInLine(input, lineNumberInt);

        //Append to text panel
        allText = String.format("***Line Number %s***\n%s\n", (lineNumber), allText);    //wrap output in header/footer
        tPanel.appendText(allText);

    }

    public void viewFieldsOnLineSingle(String input, String nameOfField, String startPosition, String numberOfChars, String lineNumber) throws Exception {
        structureReader sr = new structureReader();
        ArrayList<field> fieldArray = sr.createFieldArraySingle(nameOfField, startPosition, numberOfChars);

        //line number formatting, convert to int. Minus 1 as java arrays start from 0 and lines in editors start from 1
        int lineNumberInt = Integer.parseInt(lineNumber);
        lineNumberInt = lineNumberInt - 1;

        //Generate viewer object and return concatenated string
        viewer v = new viewer(fieldArray);
        String allText = v.viewFieldsInLine(input, lineNumberInt);

        //Append to text panel
        allText = String.format("***Line Number %s***\n%s\n", (lineNumber), allText);    //wrap output in header/footer
        tPanel.appendText(allText);

    }

}
