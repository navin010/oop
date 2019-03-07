package swingUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formPanelSingleFieldSearch extends JPanel {

    //vars
    private JLabel labelInput;
    private JLabel labelNameOfField;
    private JLabel labelLineNumber;
    private JLabel labelStartPosition;
    private JLabel labelNumberOfChars;
    private JTextField fieldInput;
    private JTextField fieldNameOfField;
    private JTextField fieldLineNumber;
    private JTextField fieldStartPosition;
    private JTextField fieldNumberOfChars;
    private JButton btnSubmit;
    private formListener fListener;


    //constructor
    public formPanelSingleFieldSearch(){

        Dimension dim = getPreferredSize();
        //System.out.println(dim);
        dim.width = 250;
        setPreferredSize(dim);          //set panel size, default size too small

        Border innerBorder = BorderFactory.createTitledBorder("Single Field Viewer");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);  //add empty border around title border for padding
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

        labelInput = new JLabel("Input File");
        fieldInput = new JTextField(10);

        labelLineNumber = new JLabel("Line Number");
        fieldLineNumber = new JTextField(10);

        labelNameOfField = new JLabel("Name Of Field");
        fieldNameOfField = new JTextField(10);

        labelStartPosition = new JLabel("Start Position");
        fieldStartPosition = new JTextField(10);

        labelNumberOfChars = new JLabel("Number Of Chars");     //Jlabel looks like it has a max of 15 chars, otherwise messes up format
        fieldNumberOfChars = new JTextField(10);

        btnSubmit = new JButton("Submit");

        btnSubmit.addActionListener(new ActionListener() {          //when submit button is clicked
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = fieldInput.getText();
                String lineNumber = fieldLineNumber.getText();
                String nameOfField = fieldNameOfField.getText();
                String startPosition = fieldStartPosition.getText();
                String numberOfChars = fieldNumberOfChars.getText();

                //form event is basically a default java event extended with a few vars, using constructor for single field event
                formEvent event = new formEvent(this, input, nameOfField, startPosition, numberOfChars, lineNumber);
                if (fListener != null){
                    fListener.formEventOccured(event);      //call formEventOccured method in main frame under fsinglePanel with new event
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
        add(labelLineNumber, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(fieldLineNumber, gc);

        /////Third Row/////
        gc.weightx = 1;                     //size relative to other cells
        gc.weighty = 0.1;                   //size relative to other cells

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(labelNameOfField, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(fieldNameOfField, gc);

        /////Fourth Row/////
        gc.weightx = 1;                     //size relative to other cells
        gc.weighty = 0.1;                   //size relative to other cells

        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(labelStartPosition, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(fieldStartPosition, gc);

        /////Fifth Row/////
        gc.weightx = 1;                     //size relative to other cells
        gc.weighty = 0.1;                   //size relative to other cells

        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(labelNumberOfChars, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(fieldNumberOfChars, gc);

        /////Sixth Row/////
        gc.weightx = 1;                     //size relative to other cells
        gc.weighty = 2;                     //size relative to other cells

        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(btnSubmit, gc);

    }

    //methods
    public void setFormListener(formListener listener){
        this.fListener = listener;          //assign listener to class variable fListener, otherwise fListener will be null
    }

}
