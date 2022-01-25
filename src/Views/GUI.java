package Views;

import Controller.Grid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel panel1;
    private JButton start;
    private JButton random;
    private JButton stop;
    private JButton next;
    private Grid grid;

    public GUI() {
        //TODO figure out how the fuck to do the menu in this
        this.grid = new Grid(10);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
/*
package Views;

import Controller.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JPanel{
    //TODO IMPLEMENTE GUI LIKE CLI
    private JFrame jf;
    private Grid grid;

    public void addCells(){
        this.jf.getContentPane().add(this.grid);
    }

    public GUI() {
        this.grid = new Grid(10);
        this.jf=new JFrame(); // adds a panel or a window in JAVA SWING
        this.jf.setSize(700, 700);
        this.jf.setTitle("Conway's Game of Life");
        var pane = this.jf.getContentPane();
        pane.add(this); //adds GUI paint to the frame
        this.addCells();
        this.jf.setLocationRelativeTo(null); //makes all positions be absolute , top left is [0;0]  bottom left is [width,height]
        this.jf.setBackground(Color.BLACK);
        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //idk
        this.jf.setVisible(true); // must not forget this on all elements or else the default is false (invisible)




        this.grid.Randomize();
        int delay = 1000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                grid.calculateNextMoment();
                var frame = getJf();
                frame.invalidate();
                frame.validate();
                frame.repaint();

            }
        };
        JButton button1 = new JButton();
        ActionListener start = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new Timer(delay, taskPerformer).start();
            }
        };
        button1.addActionListener(start);
        button1.setPreferredSize(new Dimension(20,4));
        pane.add(button1);

    }


    public JFrame getJf() {
        return jf;
    }
}

*/