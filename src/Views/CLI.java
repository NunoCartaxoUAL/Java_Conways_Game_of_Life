package Views;

import java.util.Scanner;
import Controller.Grid;

public class CLI {
    public CLI() {
        final Scanner scanner = new Scanner(System.in);
        Grid grid = new Grid(4);
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
                default:
                    break;
            }

        }
    }
}
