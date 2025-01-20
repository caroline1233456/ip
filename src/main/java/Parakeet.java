import java.util.Arrays;
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
                if (command.startsWith(("todo"))) {
                    String[] splitCom = Arrays.copyOfRange(command.split(" "),1, command.split(" ").length);
                    String result = String.join(" ", splitCom);
                    Task newTask = new Todo(false, result);
                    list.add(newTask);
                    System.out.println("____________________________________________________________");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(newTask.toString());
                    System.out.println("Now you have " + list.size() +" in the list");
                    System.out.println("____________________________________________________________");
                }
                if (command.startsWith(("deadline"))) {
                    String[] splitCom = Arrays.copyOfRange(command.split(" "),1, command.split(" ").length);
                    String result = String.join(" ", splitCom);
                    Task newTask = new Deadline(false,result);
                    list.add(newTask);
                    System.out.println("____________________________________________________________");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(newTask.toString());
                    System.out.println("Now you have " + list.size() +" in the list");
                    System.out.println("____________________________________________________________");
                }
                if (command.startsWith(("event"))) {
                    String[] splitCom = Arrays.copyOfRange(command.split(" "),1, command.split(" ").length);
                    String result = String.join(" ", splitCom);
                    Task newTask = new Event(false,result);
                    list.add(newTask);
                    System.out.println("____________________________________________________________");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(newTask.toString());
                    System.out.println("Now you have " + list.size() +" in the list");
                    System.out.println("____________________________________________________________");
                }

            }
        }
        scanner.close();

    }
}

