package swingUI;

import javax.swing.*;

public class app {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {                         //invoke later used for multi threading
            @Override
            public void run() {

                new mainFrame();                                            //create new class of mainFrame

            }
        });


    }

}
