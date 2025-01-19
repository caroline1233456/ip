import java.util.Scanner;
import java.util.ArrayList;
public class Parakeet {


    public static void main(String[] args) {
        ArrayList<Task> list = new ArrayList<>();
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
            if (command.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i + 1 + "." + list.get(i).toString());
                }
                System.out.println("____________________________________________________________");
            } else if (command.startsWith("mark")) {
                int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
                list.get(taskIndex).complete();
                System.out.println("ok, I have marked this task as done");
                System.out.println(list.get(taskIndex).toString());
            } else if (command.startsWith("unmark")) {
                int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1;
                list.get(taskIndex).unDone();
                System.out.println("ok, I have marked this task as not done yet");
                System.out.println(list.get(taskIndex).toString());
            } else {
                System.out.println("____________________________________________________________");
                System.out.println(command);
                Task task = new Task(false, command);
                list.add(task);
                System.out.println("____________________________________________________________");

            }
        }
        scanner.close();

    }
}

