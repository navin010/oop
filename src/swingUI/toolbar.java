package swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class toolbar extends JPanel implements ActionListener {

    //vars
    private JButton btnClear;
    private JButton btnPanelMultiple;
    private JButton btnPanelSingle;
    private stringListener textListener;
    private buttonListener buttonListener;

    //constructors
    public toolbar(){

        setBorder(BorderFactory.createEtchedBorder());

        btnPanelMultiple = new JButton("Multiple");
        btnPanelSingle = new JButton("Single");
        btnClear = new JButton("Clear");


        btnPanelMultiple.addActionListener(this);
        btnPanelSingle.addActionListener(this);
        btnClear.addActionListener(this);
        
        setLayout(new FlowLayout(FlowLayout.RIGHT));       //flow layout for left to right layout, add start position from left
        add(btnPanelMultiple);
        add(btnPanelSingle);
        add(btnClear);

    }

    //methods
    public void setStringListener(stringListener listener){
        this.textListener = listener;
    }

    public void setButtonListener(buttonListener listener){
        this.buttonListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();       //cast source value to a JButton type
        if (buttonClicked == btnClear){
            if(textListener != null){                         //ensures string listener was passed in to class
                textListener.textEmitted("clear");
                //System.out.println("clear button");
            }
        }
        else if (buttonClicked == btnPanelSingle){
            if(textListener != null){                         //ensures button listener was passed in to class
                textListener.textEmitted("single");
                //System.out.println("single button");
            }
        }
        else if (buttonClicked == btnPanelMultiple){
            if(textListener != null){                         //ensures button listener was passed in to class
                textListener.textEmitted("multiple");
                //System.out.println("multiple button");
            }
        }
    }
}
