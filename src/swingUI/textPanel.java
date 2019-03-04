package swingUI;

import javax.swing.*;
import java.awt.*;

public class textPanel extends JPanel {

    //vars
    private JTextArea textArea;

    //constructors
    public textPanel(){
        textArea = new JTextArea();
        setLayout(new BorderLayout());                              //textPanel border layout set
        add(new JScrollPane(textArea), BorderLayout.CENTER);        //wrap text area in scroll pane to add scroll function, centre the scroll pane
    }

    //methods
    public void appendText(String text){
        textArea.append(text);
    }


}
