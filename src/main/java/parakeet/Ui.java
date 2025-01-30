package parakeet;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;
    public Ui() {
        Scanner scanner = new Scanner(System.in);
        this.scanner = scanner;
    }

    /**
     * Print the given message on the screen.
     *
     * @param message the String you want to print on Screen.
     */
    public void printMessage(String message) {
        System.out.println(message);

    }

    /**
     * Print a line on the screen.
     */
    public void printLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Print the welcome message on the screen.
     */
    public void printWelcome() {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm parakeet.Parakeet");
        System.out.println("What can I do for you?");

        System.out.println("____________________________________________________________");
    }
    public String readCommand() {
        String command = this.scanner.nextLine();
        return command;
    }

    public void colseScanner() {
        scanner.close();
    }

    public void printExit() {
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

}
