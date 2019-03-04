package swingUI;

import javax.swing.*;
import java.awt.*;

public class toolbar extends JPanel {

    //vars
    private JButton btn1;
    private JButton btn2;

    //constructors
    public toolbar(){
        btn1 = new JButton("one");
        btn2 = new JButton("two");

        setLayout(new FlowLayout(FlowLayout.LEFT));       //flow layout for left to right layout, add start position from left
        add(btn1);
        add(btn2);

    }

    //methods


}
