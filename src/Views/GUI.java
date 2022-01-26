package Views;

import Controller.Grid;
import Models.Cell;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private final ActionListener taskPerformer;
    private final SpringLayout lay2;
    private JPanel panel1;
    private Grid grid;
    private JPanel panel2;
    private JPanel panel3;

    public GUI(){

        this.grid = new Grid(50);
        this.setSize(700, 700);
        this.setTitle("Conway's Game of Life");

        this.panel2 = new JPanel();
        panel2.setBackground(Color.DARK_GRAY);
        this.panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);


        this.setContentPane(panel2);

        var layout = new SpringLayout();
        panel2.setLayout(layout);
        var lay2 = new SpringLayout();
        this.lay2 = lay2;
        panel1.setLayout(lay2);

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (((Cell) evt.getSource()).isLife()){
                    ((Cell) evt.getSource()).setBackground(Color.GRAY);
                    ((Cell) evt.getSource()).setLife(false);
                }else{
                    ((Cell) evt.getSource()).setBackground(Color.yellow);
                    ((Cell) evt.getSource()).setLife(true);
                }

            }
        };
        int delay = 200; //milliseconds
        ActionListener test1 = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                grid.calculateNextMoment();
                for (Cell[] cellrow :grid.getCells()) {
                    for (Cell cell : cellrow) {
                        var test = cell;
                        if (cell.isLife()) {
                            cell.setBackground(Color.yellow);
                        } else {
                            cell.setBackground(Color.GRAY);
                        }

                    }
                }
            }
        };
        JButton button1 = new JButton();
        ActionListener start = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new javax.swing.Timer(delay,test1).start();
            }
        };
        button1.addActionListener(start);
        button1.setPreferredSize(new Dimension(20,4));
        panel2.add(button1);
        this.taskPerformer = taskPerformer;

        layout.putConstraint(SpringLayout.WEST,panel1,20,SpringLayout.WEST,panel2);
        layout.putConstraint(SpringLayout.NORTH,panel1,20,SpringLayout.NORTH,panel2);
        panel1.setPreferredSize(new Dimension(400, 400));
        System.out.println(panel1.getSize());
        this.addCells();
        panel2.add(panel1);

        this.setResizable(false);

        this.setLocationRelativeTo(null); //makes all positions be absolute , top left is [0;0]  bottom left is [width,height]
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //idk
        this.setVisible(true); // must not forget this on all elements or else the default is false (invisible)


    }

    public void addCells(){
        int x=10;
        int y=10;
        int width = 11;
        this.grid.Randomize();
        for (Cell[] cellrow :this.grid.getCells()) {
            for (Cell cell: cellrow) {
                var test = cell;
                test.setPreferredSize(new Dimension(10,10));
                test.addActionListener(taskPerformer);
                if(cell.isLife()){
                    test.setBackground(Color.yellow);
                }else{
                    test.setBackground(Color.gray);
                }
                lay2.putConstraint(SpringLayout.WEST,test,x,SpringLayout.WEST,panel2);
                lay2.putConstraint(SpringLayout.NORTH,test,y,SpringLayout.NORTH,panel2);
                panel1.add(test);
                x+=11;
            }
            x=10;
            y+=width+2;
        }
        y=10;



    }


}
/*private JPanel panel1;
    private Grid grid;
    private JPanel panel2;

    public void addCells(){
        this.getContentPane().add(this.grid);
    }

    public GUI(){
        this.grid = new Grid(22);
        this.setSize(700,700);
        this.setBackground(Color.black);
        this.add(this);
        this.add(grid);
        this.setContentPane(panel1);
        this.setVisible(true);

        this.grid = new Grid(10);
                this.setSize(700, 700);
                this.setTitle("Conway's Game of Life");
                this.panel2 = new JPanel();
                panel2.setBackground(Color.cyan);

                this.add(panel1);
                this.add(panel2);


                this.setLocationRelativeTo(null); //makes all positions be absolute , top left is [0;0]  bottom left is [width,height]
                this.setBackground(Color.BLACK);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //idk
                this.setVisible(true); // must not forget this on all elements or else the default is false (invisible)

                 SpringLayout lyt = new SpringLayout();
                lyt.putConstraint(SpringLayout.WEST,button4,5,SpringLayout.WEST,pnl);
                }*/
