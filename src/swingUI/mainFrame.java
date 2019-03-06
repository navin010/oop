package swingUI;

import swingUI.flatFile.field;
import swingUI.flatFile.structureReader;
import swingUI.flatFile.viewer;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class mainFrame extends JFrame {

    //vars
    private textPanel tPanel;
    private toolbar tbar;
    private formPanel fPanel;
    private String globalStructure = "";
    //static ArrayList<field> fieldArray = new ArrayList<field>();

    //constructor
    public mainFrame(){
        super("FF Viewer");                             //call JFrame constructor
        setSize(600,500);                       //calling methods from super directly
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit program when gui is closed
        setVisible(true);

        setLayout(new BorderLayout());
        tPanel = new textPanel();
        tbar = new toolbar();
        fPanel = new formPanel();

        add(fPanel, BorderLayout.WEST);
        add(tbar, BorderLayout.SOUTH);
        add(tPanel, BorderLayout.CENTER);

        /*
        tbar.setStringListener(new stringListener() {
            @Override
            public void textEmitted(String text) {
                //tPanel.appendText(text);
            }
        });
        */

        tbar.setButtonListener(new buttonListener() {
            @Override
            public void buttonPressed() {
                tPanel.clearText();
            }
        });

        fPanel.setFormListener(new formListener() {
            @Override
            public void formEventOccured(formEvent e) {
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

}
