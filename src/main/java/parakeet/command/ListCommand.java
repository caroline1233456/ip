package parakeet.command;


import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;

public class ListCommand extends Command {
    public ListCommand() {
    }

    /**
     * Executes the command to display the list of tasks.
     * This method prints the entire list of tasks to the UI by calling the
     * {@link TaskList#toString()} method and then prints it to the user.
     *
     * @param taskList the list of tasks to be displayed.
     * @param ui the UI that handles the display of messages to the user.
     * @param storage the storage used to save the tasks (not used in this method).
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        String response = taskList.toString();
        return response;
    }
}
