import java.awt.event.*;
import javax.swing.*;

public class Textdialog extends JDialog implements KeyListener, MouseListener {

    JLabel jLabel;
    ImageIcon icon;

    public Textdialog(String string) {
        jLabel = new JLabel(string, icon, SwingConstants.CENTER);
        this.add(jLabel);
        this.setLocation(100,500);
        this.setSize(800,100);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addMouseListener(this);
        this.setModal(true);
        this.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1)
            this.dispose();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == ' '||e.getKeyCode() == '\n')
            this.dispose();
    }

    public void keyReleased(KeyEvent e) {

    }

}
