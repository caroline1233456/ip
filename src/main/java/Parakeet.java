import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;
public class Parakeet {


    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Storage storage = new Storage();
        storage.readFromFile(taskList);
        Ui ui = new Ui();
        Parser parser = new Parser();
        ui.printWelcome();
        while (true) {
            String command = ui.readCommand();
            try {
                Command parsedCommand = parser.parse(command);
                if (parsedCommand instanceof ExitCommand) {
                    parsedCommand.execute(taskList, ui, storage);
                    break;
                }
                parsedCommand.execute(taskList, ui, storage);

            } catch(InvalidInputError error) {
                ui.printLine();
                ui.printMessage(error.getMessage());
                ui.printLine();
            }

        }

    }


}

