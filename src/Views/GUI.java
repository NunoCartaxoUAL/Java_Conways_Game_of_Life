package Views;

import Controller.Grid;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;


public class GUI extends JPanel{
    //TODO IMPLEMENTE GUI LIKE CLI
    private JFrame jf;
    private Grid grid;

    public void addCells(){
        this.jf.getContentPane().add(this.grid);
    }

    public GUI(final Grid grid) {
        this.grid = grid;
        this.jf=new JFrame(); // adds a panel or a window in JAVA SWING
        this.jf.setSize(700, 700);
        this.jf.setTitle("Conway's Game of Life");
        this.jf.getContentPane().add(this); //adds GUI paint to the frame
        this.addCells();
        this.jf.setLocationRelativeTo(null); //makes all positions be absolute , top left is [0;0]  bottom left is [width,height]
        this.jf.setBackground(Color.BLACK);
        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //idk
        this.jf.setVisible(true); // must not forget this on all elements or else the default is false (invisible)
    }


    public JFrame getJf() {
        return jf;
    }
}
