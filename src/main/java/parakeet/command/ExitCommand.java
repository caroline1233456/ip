package parakeet.command;

import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;
public class ExitCommand extends Command {

    public ExitCommand() {

    }

    /**
     * Executes the command to exit the application.
     * This method saves the current task list to the file, displays a message indicating
     * that the tasks have been saved, and then prints the exit message to the UI.
     * Finally, it closes the scanner used for user input.
     *
     * @param taskList the list of tasks to be saved.
     * @param ui the UI that handles the display of messages to the user.
     * @param storage the storage used to save the tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printExit();
        storage.writeToFile(taskList);
        ui.printMessage("parakeet.task.Task list has been saved");
        ui.colseScanner();
    }
}
