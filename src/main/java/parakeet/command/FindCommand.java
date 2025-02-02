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
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        TaskList subList = taskList.find(this.keyword);
        String response = subList.toString();
        return response;

    }
}
