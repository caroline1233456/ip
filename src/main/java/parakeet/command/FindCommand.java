package parakeet.command;

import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        TaskList subList = taskList.find(this.keyword);
        ui.printLine();
        ui.printMessage(subList.toString());
        ui.printLine();
    }
}
