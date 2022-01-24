package Views;

import java.util.Scanner;
import Controller.Grid;

public class CLI {
    public CLI() {
        final Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid(10);
        while (true) {

            var input = scanner.nextLine();
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "SHOW":
                    var show = grid.show();
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
                    var size = grid.getSize();
                    boolean[][] newValues = new boolean[size][size];
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            System.out.println(i+" "+j+" ");
                            newValues[i][j] = (scanner.nextLine().matches("1"));
                            System.out.println(newValues[i][j]);
                        }
                    }
                    System.out.println(newValues);
                    grid.updateAll(newValues);
                    System.out.println("Updated every position");
                    break;
                case "NEXT":
                    grid.calculateNextMoment();
                    System.out.println("Next moment calculated and updated");
                default:
                    break;
            }

        }
    }
}
