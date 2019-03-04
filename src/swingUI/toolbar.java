package swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class toolbar extends JPanel implements ActionListener {

    //vars
    private JButton btn1;
    private JButton btn2;
    private stringListener textListener;

    //constructors
    public toolbar(){
        btn1 = new JButton("one");
        btn2 = new JButton("two");

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));       //flow layout for left to right layout, add start position from left
        add(btn1);
        add(btn2);

    }

    //methods
    public void setStringListener(stringListener listener){
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();       //cast source value to a JButton type
        if (buttonClicked == btn1){
            if(textListener != null){
                textListener.textEmitted("bt1 clicked\n");
            }
        }
        else {
            if(textListener != null){
                textListener.textEmitted("bt2 clicked\n");
            }
        }
    }
}
