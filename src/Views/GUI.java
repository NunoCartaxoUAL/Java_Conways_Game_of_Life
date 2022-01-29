package Views;

import Controller.Grid;
import Models.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private final SpringLayout lyt;
    private final int width;
    private final int heigth;
    private final JPanel gamePanel;
    private final Grid grid;
    private final JPanel mainPanel;

    public GUI(int size){

        //basic setup of the JFrame
        this.grid = new Grid(size);
        this.setSize(740, 800);
        this.width =this.getSize().width;
        this.heigth = this.getSize().height;
        var lyt = new SpringLayout();
        this.lyt = lyt;
        this.setTitle("Conway's Game of Life");

        //basic setup of the 2 JPanels , main and game
        this.mainPanel = new JPanel();
        this.gamePanel = new JPanel();
        this.setContentPane(mainPanel);
        gamePanel.setPreferredSize(new Dimension(this.width-100, this.heigth-100));
        mainPanel.setBackground(Color.DARK_GRAY);
        gamePanel.setBackground(Color.BLACK);
        gamePanel.setLayout(lyt);
        mainPanel.setLayout(lyt);

        //constraints for those panels in springs
        lyt.putConstraint(SpringLayout.WEST,gamePanel,10,SpringLayout.WEST,mainPanel);
        lyt.putConstraint(SpringLayout.EAST,gamePanel,-50,SpringLayout.EAST,mainPanel);
        lyt.putConstraint(SpringLayout.NORTH,gamePanel,10,SpringLayout.NORTH,mainPanel);


        //Various ActionListeners for the different buttons in game
        int delay = 500; //milliseconds
        ActionListener nextMoment = new ActionListener() {
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
        //timer for the Actions that need repetition
        var timer1 = new javax.swing.Timer(delay,nextMoment);
        ActionListener start = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                timer1.start();
            }
        };
        ActionListener stop = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                timer1.stop();
            }
        };
        ActionListener rand = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                grid.Randomize();
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

        //Basic setup of buttons
        JButton startButton = new JButton();
        startButton.setPreferredSize(new Dimension(100,20));
        startButton.setText("Start");
        startButton.addActionListener(start);
        lyt.putConstraint(SpringLayout.WEST,startButton,10,SpringLayout.WEST,mainPanel);
        lyt.putConstraint(SpringLayout.NORTH,startButton,10,SpringLayout.SOUTH,gamePanel);

        JButton stopButton = new JButton();
        stopButton.setPreferredSize(new Dimension(100,20));
        stopButton.setText("Stop");
        stopButton.addActionListener(stop);
        lyt.putConstraint(SpringLayout.WEST,stopButton,110,SpringLayout.WEST,mainPanel);
        lyt.putConstraint(SpringLayout.NORTH,stopButton,10,SpringLayout.SOUTH,gamePanel);

        JButton randButton = new JButton();
        randButton.setPreferredSize(new Dimension(100,20));
        randButton.setText("Random");
        randButton.addActionListener(rand);
        lyt.putConstraint(SpringLayout.WEST,randButton,210,SpringLayout.WEST,mainPanel);
        lyt.putConstraint(SpringLayout.NORTH,randButton,10,SpringLayout.SOUTH,gamePanel);

        JButton nextButton = new JButton();
        nextButton.setPreferredSize(new Dimension(100,20));
        nextButton.setText("Next");
        nextButton.addActionListener(nextMoment);
        lyt.putConstraint(SpringLayout.WEST,nextButton,310,SpringLayout.WEST,mainPanel);
        lyt.putConstraint(SpringLayout.NORTH,nextButton,10,SpringLayout.SOUTH,gamePanel);

        //adding everything to main Panel
        mainPanel.add(nextButton);
        mainPanel.add(randButton);
        mainPanel.add(startButton);
        mainPanel.add(stopButton);
        this.addCells();
        mainPanel.add(gamePanel);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); //Sets all elements to be visible
    }

    //Adds all cells that extend JButton to the frame
    public void addCells(){

        //Creates an ActionListener for every cell that is a button so you can turn OFF or ON a cell
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

        //Rough Setup so the buttons scale with the window size,
        //had issues with SpringLayout so its not perfect and breaks at high cell count

        int cellWidth = (((this.width)-160)/(this.grid.getGridSize()));
        int x=10;
        int y=10;

        for (Cell[] cellrow :this.grid.getCells()) {
            for (Cell cell: cellrow) {

                //for each cell in each cell row
                //add it to the frame and do some adjustments
                //like adding constraints or sizes
                cell.setPreferredSize(new Dimension(cellWidth,cellWidth));
                cell.addActionListener(taskPerformer);
                if(cell.isLife()){
                    cell.setBackground(Color.yellow);
                }else{
                    cell.setBackground(Color.gray);
                }
                cell.setBorder(null);
                lyt.putConstraint(SpringLayout.WEST,cell,x,SpringLayout.WEST,mainPanel);
                lyt.putConstraint(SpringLayout.NORTH,cell,y,SpringLayout.NORTH,mainPanel);
                gamePanel.add(cell);
                x+=cellWidth+1;
            }
            x=10;
            y+=cellWidth+1;
        }
    }
}
