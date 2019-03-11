package swingUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formPanelStructure extends JPanel {

    //vars
    private JLabel labelInput;
    private JLabel labelStructure;
    private JLabel labelLineNumber;
    private JTextField fieldInput;
    private JTextField fieldStructure;
    private JTextField fieldLineNumber;
    private JButton btnSubmit;
    private formListener fListener;

    //private JFileChooser fileOpen;

    //constructor
    public formPanelStructure(){

        Dimension dim = getPreferredSize();
        //System.out.println(dim);
        dim.width = 250;
        setPreferredSize(dim);

        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);  //add empty border around title border for padding
        Border innerBorder = BorderFactory.createTitledBorder("Structure Field Viewer");
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

        labelInput = new JLabel("Input File");
        fieldInput = new JTextField(10);
        labelStructure = new JLabel("Structure File");
        fieldStructure = new JTextField(10);
        labelLineNumber = new JLabel("Line Number");
        fieldLineNumber = new JTextField(10);
        btnSubmit = new JButton("Submit");


        btnSubmit.addActionListener(new ActionListener() {          //when submit button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = fieldInput.getText();
                String structure = fieldStructure.getText();
                String lineNumber = fieldLineNumber.getText();
                //form event is basically a default java event extended with a few vars
                formEvent event = new formEvent(this, input, structure, lineNumber);
                //check if fListener has been passed in from the main frame via method setFormListener, if it has not fListener=null
                if (fListener != null){
                    fListener.formEventOccured(event);      //call formEventOccured method in main frame with new event
                }
            }
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        /////First Row/////
        gc.weightx = 1;                     //size relative to other cells
        gc.weighty = 0.1;                   //size relative to other cells

        gc.gridx = 0;                       //start position x
        gc.gridy = 0;                       //start position y
        gc.fill = GridBagConstraints.NONE;  //decides whether to take up all the space in a cell or not
        gc.anchor = GridBagConstraints.LINE_END;        //anchor the label to the right
        gc.insets = new Insets(0,0,0,5);
        add(labelInput, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;      //anchor the field to the left to join the label and field together
        gc.insets = new Insets(0,0,0,0);
        add(fieldInput, gc);

        /////Second Row/////
        gc.weightx = 1;                     //size relative to other cells
        gc.weighty = 0.1;                   //size relative to other cells

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(labelStructure, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(fieldStructure, gc);

        /////Third Row/////
        gc.weightx = 1;                     //size relative to other cells
        gc.weighty = 0.1;                   //size relative to other cells

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(labelLineNumber, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(fieldLineNumber, gc);

        /////Fourth Row/////
        gc.weightx = 1;                     //size relative to other cells
        gc.weighty = 2;                     //size relative to other cells

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(btnSubmit, gc);
    }

    //methods
    public void setFormListener(formListener listener){
        this.fListener = listener;          //assign listener to class variable fListener, otherwise fListener will be null
    }

}
