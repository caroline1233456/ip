package parakeet;

import parakeet.command.Command;
import parakeet.command.ExitCommand;


import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * The Parakeet class represents the main application for managing tasks.
 * It interacts with the storage system, user interface, and task list to allow the user
 * to perform actions such as adding, removing, and viewing tasks.
 *
 * <p>This class initializes the necessary components, reads from storage, and listens
 * for user input. It processes the input using a parser and executes corresponding
 * commands until the user chooses to exit the program.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2025-01-29
 */
public class Parakeet {
    private Storage storage;

    private TaskList taskList;
    private Ui ui;
    public Parakeet() {
        this.ui = new Ui();
        this.taskList = new TaskList();
        Path path = Paths.get("data", "parakeet.txt");
        this.storage = new Storage(path);
    }

    /**
     * Runs the Parakeet application. This method:
     * - Reads tasks from storage
     * - Displays a welcome message
     * - Processes commands input by the user in an infinite loop
     * - Executes the corresponding command based on user input
     * - Terminates when the ExitCommand is issued
     */
    public void run() {
        storage.readFromFile(taskList);
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

    /**
     * The main method to run the Parakeet application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        new Parakeet().run();
    }


}

