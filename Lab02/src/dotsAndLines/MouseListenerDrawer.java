
package dotsAndLines;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

// You don't need to know what is going on in here -- you'll learn about it later.
public class MouseListenerDrawer extends JPanel implements MouseListener{
    
    protected int myWindowWidth = 700;
    protected int myWindowHeight = 500;
    
    
    public MouseListenerDrawer() {
        JFrame easel = new JFrame();      
        easel.setSize (myWindowWidth, myWindowHeight);
        easel.add (this);
        easel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener (this);
        easel.setVisible (true);
    }
    
    
    public void erase (Graphics g) {
        g.setColor (Color.white);
        g.fillRect (0, 0, myWindowWidth, myWindowHeight);
        g.setColor (Color.black);
    }
    
    
    // Mouse Listener Stuff
    @Override
	public void mouseClicked (MouseEvent event) {
    }
    
    @Override
	public void mouseReleased (MouseEvent event) {
    }
    
    @Override
	public void mousePressed (MouseEvent event) {
    }
    
    @Override
	public void mouseEntered (MouseEvent event) {
    }
    
    @Override
	public void mouseExited (MouseEvent event) {
    }
}
