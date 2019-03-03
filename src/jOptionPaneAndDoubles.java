import javax.swing.JOptionPane;

public class jOptionPaneAndDoubles {

    //constructor
    public jOptionPaneAndDoubles(){}

    //methods
    public void fingers(){
        String fingers = JOptionPane.showInputDialog("how many fingers you have?");
        JOptionPane.showMessageDialog(null, "you have " + fingers + " fingers");
    }

    public void fingers_double(){
        Double number = Double.parseDouble(JOptionPane.showInputDialog("what is 3 / 2 ?"));
        if((number - 1.5) < 0.00001){
            //if users inputs 1.5
            JOptionPane.showMessageDialog(null, "you're right");
        }
        else {
            JOptionPane.showMessageDialog(null, "you're wrong");
        }
    }


}
