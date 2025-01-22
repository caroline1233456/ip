import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;
public class Parakeet {


    public static void main(String[] args) {
        ArrayList<Task> list = new ArrayList<>();
        Parser parser = new Parser();
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Parakeet");
        System.out.println("What can I do for you?");

        System.out.println("____________________________________________________________");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            try {
                ParsedCommand parsedCommand = parser.parse(command);
                if (parsedCommand.getCommandType() == CommandType.BYE) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("____________________________________________________________");
                    break;
                }
                handleCommand(parsedCommand, list);

            } catch(InvalidInputError error) {
                System.out.println("____________________________________________________________");
                System.out.println(error.getMessage());
                System.out.println("____________________________________________________________");
            }

        }
        scanner.close();
    }

    public static void handleCommand(ParsedCommand parsedCommand, ArrayList<Task> list) {
        CommandType type = parsedCommand.getCommandType();
        int taskIndex = parsedCommand.getIndex();
        String description = parsedCommand.getDescription();
        String timeOne = parsedCommand.getTimeOne();
        String timeTwo = parsedCommand.getTimeTwo();
        if (type == CommandType.BYE) {
            System.out.println("____________________________________________________________");
            System.out.println("Bye. Hope to see you again soon!");
            System.out.println("____________________________________________________________");
        } else if(type == CommandType.LIST) {
            System.out.println("____________________________________________________________");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + "." + list.get(i).toString());
            }
            System.out.println("____________________________________________________________");
        }else if (type == CommandType.MARK) {
                list.get(taskIndex).complete();
                System.out.println("____________________________________________________________");
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(list.get(taskIndex).toString());
                System.out.println("____________________________________________________________");
        }else if (type == CommandType.UNMARK) {
                list.get(taskIndex).unDone();
                System.out.println("____________________________________________________________");
                System.out.println("Ok, I've marked this task as not done yet: ");
                System.out.println(list.get(taskIndex).toString());
                System.out.println("____________________________________________________________");
        } else if (type == CommandType.DELETE) {
            Task toDelete = list.get(taskIndex);
            list.remove(taskIndex);
            System.out.println("____________________________________________________________");
            System.out.println("Noted. I've removed this task:");
            System.out.println(toDelete.toString());
            System.out.println("Now you have " + list.size() + " tasks in the list");
            System.out.println("____________________________________________________________");
        } else if (type == CommandType.TODO) {
            Task newTask = new Todo(false, description);
            list.add(newTask);
            System.out.println("____________________________________________________________");
            System.out.println("Got it. I've added this task: ");
            System.out.println(newTask.toString());
            System.out.println("Now you have " + list.size() +" tasks in the list");
            System.out.println("____________________________________________________________");
        } else if (type == CommandType.DEADLINE) {
                Task newDeadline = new Deadline(false, description, timeOne);
                list.add(newDeadline);
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task: ");
                System.out.println(newDeadline.toString());
                System.out.println("Now you have " + list.size() + " tasks in the list");
                System.out.println("____________________________________________________________");
        } else if (type == CommandType.EVENT) {
            Task newEvent = new Event(false, description, timeOne, timeTwo);
            list.add(newEvent);
            System.out.println("____________________________________________________________");
            System.out.println("Got it. I've added this task: ");
            System.out.println(newEvent.toString());
            System.out.println("Now you have " + list.size() + " tasks in the list");
            System.out.println("____________________________________________________________");
        } else {
            System.out.println("____________________________________________________________");
            System.out.println("sorry, I don't understand what you mean");
            System.out.println("____________________________________________________________");
        }
    }
}

