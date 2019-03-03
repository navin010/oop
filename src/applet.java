import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


public class applet extends Applet {

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;      //cast g to graphics 2d newer version
        Ellipse2D.Double e = new Ellipse2D.Double(0,0,300,300);
        g2.draw(e);
    }

}
