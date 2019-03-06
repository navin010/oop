package swingUI;

import swingUI.flatFile.structureReader;
import swingUI.flatFile.viewer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame {

    //vars
    //private JTextArea textArea;
    private textPanel tPanel;
    private toolbar tbar;
    private formPanel fPanel;

    //constructor
    public mainFrame(){
        super("FF Viewer");                             //call JFrame constructor
        setSize(600,500);                       //calling methods from super directly
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit program when gui is closed
        setVisible(true);

        setLayout(new BorderLayout());
        //textArea = new JTextArea();
        tPanel = new textPanel();
        tbar = new toolbar();
        fPanel = new formPanel();

        add(fPanel, BorderLayout.WEST);
        add(tbar, BorderLayout.NORTH);
        add(tPanel, BorderLayout.CENTER);

        //tbar.setTextPanel(tPanel);

        tbar.setStringListener(new stringListener() {
            @Override
            public void textEmitted(String text) {
                //System.out.println(text);
                tPanel.appendText(text);
            }
        });

        fPanel.setFormListener(new formListener() {
            @Override
            public void formEventOccured(formEvent e) {
                String input = e.getInput();
                String structure = e.getStructure();
                String lineNumber = e.getLineNumber();

                //tPanel.appendText("input:" + input + " structure:" + structure + " lineNumber:" + lineNumber + "\n");
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
        viewer v = new viewer(sr.createFieldArray("C:/Java/OOP/src/flatFileViewer/structure.txt"));
        v.viewFieldsInLine("C:/Java/OOP/src/flatFileViewer/input.txt", 1);
    }

}
