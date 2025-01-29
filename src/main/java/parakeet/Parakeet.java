package parakeet;

import parakeet.command.Command;
import parakeet.command.ExitCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Parakeet {
    private Storage storage;
    private File file;
    private TaskList taskList;
    private Ui ui;
    public Parakeet() {
        this.ui = new Ui();
        this.taskList = new TaskList();
        Path path = Paths.get("data", "parakeet.txt");
        this.file = path.toFile();
        this.storage = new Storage(path);
    }

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

    public static void main(String[] args) {
        new Parakeet().run();
    }


}

