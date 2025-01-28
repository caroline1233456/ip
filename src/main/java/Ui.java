import java.util.Scanner;

public class Ui {
    private Scanner scanner;
    public Ui() {
        Scanner scanner = new Scanner(System.in);
        this.scanner = scanner;
    }

    public void printMessage(String message) {
        System.out.println(message);

    }

    public void printLine() {
        System.out.println("____________________________________________________________");
    }

    public void printWelcome() {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Parakeet");
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
