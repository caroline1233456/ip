package parakeet.command;

import parakeet.Storage;
import parakeet.TaskList;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String execute(TaskList taskList, Storage storage) {
        TaskList subList = taskList.find(this.keyword);
        String response = subList.toString();
        return response;

    }
}
