package swingUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame {

    //vars
    //private JTextArea textArea;
    private textPanel tPanel;
    private JButton btn;

    //constructor
    public mainFrame(){
        super("Hello World");                            //call JFrame constructor
        setSize(600,500);                       //calling methods from super directly
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit program when gui is closed
        setVisible(true);

        setLayout(new BorderLayout());
        //textArea = new JTextArea();
        tPanel = new textPanel();
        btn = new JButton("Click");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //textArea.append("clicked\n");

            }
        });

        add(tPanel, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);


    }

    //methods


}
