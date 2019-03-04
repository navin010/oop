package swingUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class formPanel extends JPanel {

    private JLabel labelOne;
    private JLabel labelTwo;
    private JTextField field1;
    private JTextField field2;
    private JButton btnSubmit;

    public formPanel(){

        Dimension dim = getPreferredSize();
        System.out.println(dim);
        dim.width = 250;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);  //add empty border around title border for padding
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

        labelOne = new JLabel("name");
        labelTwo = new JLabel("occupation");
        field1 = new JTextField(10);
        field2 = new JTextField(10);
        btnSubmit = new JButton("submit");

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;                     //size relative to other cells
        gc.weighty = 1;                     //size relative to other cells

        /////First Row/////

        gc.gridx = 0;                       //start position x
        gc.gridy = 0;                       //start position y
        gc.fill = GridBagConstraints.NONE;  //decides whether to take up all the space in a cell or not
        gc.anchor = GridBagConstraints.LINE_END;        //anchor the label to the right
        add(labelOne, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;      //anchor the field to the left to join the label and field together
        add(field1, gc);

        /////Second Row/////

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(labelTwo, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(field2, gc);

        /////Third Row/////

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(btnSubmit, gc);


    }

}
