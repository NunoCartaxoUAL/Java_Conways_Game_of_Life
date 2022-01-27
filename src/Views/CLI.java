package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import Controller.Grid;
import java.util.Random;


public class CLI {
    public CLI(Scanner scanner) {
        System.out.println("Please choose the size of the grid:");
        int gridSize = Integer.valueOf(scanner.nextLine());
        Grid grid = new Grid(gridSize);
        boolean run = true;
        System.out.println("Please choose an instruction, use HELP to see all available instructions");
        while (run) {
            System.out.print(">");
            var input = scanner.nextLine();
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "SHOW":
                    var show = grid.showGrid();
                    System.out.println(show);
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
                    grid.Randomize();
                    System.out.println("Sucessfully randomized");
                    break;
                case "NEXT":
                    grid.calculateNextMoment();
                    System.out.println("Next moment calculated and updated");
                    break;
                case "HELP":
                    System.out.println(
                                "AVAILABLE COMMANDS ARE: \n" +
                                "SHOW : shows the state of the board \n" +
                                "CHANGE : changes the state of a specific cell\n" +
                                "CHANGEALL : asks for the state of each cell left to right top to bottom\n" +
                                "RANDOM : randomizes the state of every cell in the board\n " +
                                "NEXT : Calculates the next exact moment in the simulation\n " +
                                "STOP : Stops the program\n "
                    );
                case "STOP":
                    run=false;
                    break;
                default:
                    System.out.println("invalid instruction");
                    break;
            }

        }
    }
}
