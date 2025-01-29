package parakeet.command;

import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;
public class ExitCommand extends Command {

    public ExitCommand() {

    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printExit();
        storage.writeToFile(taskList);
        ui.printMessage("parakeet.task.Task list has been saved");
        ui.colseScanner();
    }
}
