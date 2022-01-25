package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import Controller.Grid;
import java.util.Random;
import javax.swing.Timer;

public class CLI {
    public CLI() {
        final Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid(50);
        GUI gui = new GUI(grid);
        while (true) {

            var input = scanner.nextLine();
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "SHOW":
                    var show = grid.showGrid();
                    System.out.println(show);
                    break;
                case "PRINT":
                    System.out.println(grid.toString());
                    break;
                case "CHANGE":
                    int px = Integer.parseInt(commands[1]);
                    int py = Integer.parseInt(commands[2]);
                    grid.changeCell(px,py);
                    System.out.println("Successfully changed the cell's state");
                    break;
                case "CHANGEALL":
                    var size = grid.getGridSize();
                    boolean[][] newValues = new boolean[size][size];
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            newValues[i][j] = (scanner.nextLine().matches("1"));
                        }
                    }
                    grid.updateAll(newValues);;
                    break;
                case "RANDOM":
                    size = grid.getGridSize();
                    Random rd = new Random(); // creating Random object
                    boolean[][] newValues2 = new boolean[size][size];
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            newValues2[i][j] = (rd.nextInt(2)==1);
                        }
                    }
                    grid.updateAll(newValues2);
                    break;
                case "NEXT":
                    grid.calculateNextMoment();
                    System.out.println("Next moment calculated and updated");
                    break;
                case "GUI":
                    gui.addCells();
                    break;
                case "TEST":
                    //TODO REMOVE THIS FROM HERE AND MOVE TO GUI
                    int delay = 100; //milliseconds
                    ActionListener taskPerformer = new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {

                            grid.calculateNextMomentTest();
                            var frame = gui.getJf();
                            frame.invalidate();
                            frame.validate();
                            frame.repaint();

                        }
                    };
                    new Timer(delay, taskPerformer).start();
                    break;
                default:
                    break;
            }

        }
    }
}
