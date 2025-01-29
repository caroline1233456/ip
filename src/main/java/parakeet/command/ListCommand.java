package parakeet.command;


import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;

public class ListCommand extends Command {
    public ListCommand() {
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printLine();
        ui.printMessage(taskList.toString());
        ui.printLine();
    }
}
