package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;


public class GUI extends JPanel{

    private JFrame jf;

    public void paint(Graphics gp) //paints stuff , i dont rly know how
    {
        gp.fillRect(50, 50, 600, 600); //makes a big black square

    }

    public void addCells(){
        this.jf.getContentPane();
    }

    public GUI() {
        this.jf=new JFrame(); // adds a panel or a window in JAVA SWING
        this.jf.setSize(700, 700);
        this.jf.setTitle("Draw Chess Board");
        this.jf.getContentPane().add(this); //adds GUI paint to the frame
        this.jf.setLocationRelativeTo(null); //makes all positions be absolute , top left is [0;0]  bottom left is [width,height]
        this.jf.setBackground(Color.BLACK);
        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //idk
        this.jf.setVisible(true); // must not forget this on all elements or else the default is false (invisible)
    }


}
