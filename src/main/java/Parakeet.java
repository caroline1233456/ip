import java.util.Scanner;
public class Parakeet {
    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Parakeet");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
        Scanner scanner = new Scanner(System.in);
        while (true) {

            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            }
            System.out.println("____________________________________________________________");
            System.out.println(command);
            System.out.println("____________________________________________________________");

        }
        scanner.close();

    }
}
