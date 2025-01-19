import java.util.Scanner;
import java.util.ArrayList;
public class Parakeet {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<String>();
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
            if (command.equalsIgnoreCase("list")){
                System.out.println("____________________________________________________________");
                for(int i=0; i<list.size();i++){
                    System.out.println(i+1+"."+list.get(i).toString());
                }
                System.out.println("____________________________________________________________");
            }
            System.out.println("____________________________________________________________");
            System.out.println(command);
            list.add(command);
            System.out.println("____________________________________________________________");

        }
        scanner.close();

    }
}
