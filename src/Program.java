
import Views.CLI;
import Views.GUI;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
            final Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose between GUI and CLI:");
            System.out.print(">");
            String Choice = scanner.nextLine();
            switch (Choice) {
                case "CLI":
                    new CLI(scanner);
                    break;
                case "GUI":
                    System.out.println("Please choose the size of the grid:");
                    System.out.print(">");
                    int size = Integer.valueOf(scanner.nextLine());
                    new GUI(size);
                    break;
                default:
                    System.out.println("invalid choice");
            }


    }
}
