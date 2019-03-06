package swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class toolbar extends JPanel implements ActionListener {

    //vars
    private JButton btnClear;
    private stringListener textListener;
    private buttonListener buttonListener;

    //constructors
    public toolbar(){

        setBorder(BorderFactory.createEtchedBorder());

        btnClear = new JButton("Clear");
        btnClear.addActionListener(this);
        
        setLayout(new FlowLayout(FlowLayout.RIGHT));       //flow layout for left to right layout, add start position from left
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
            if(buttonListener != null){                         //ensures button listener was passed in to class
                buttonListener.buttonPressed();
            }
        }
    }
}
