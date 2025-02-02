package parakeet.command;

import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;


public class MarkCommand extends Command {
    private int taskIndex;



    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the command to mark a task as completed.
     * This method marks the task at the specified index in the task list as completed,
     * then prints a confirmation message to the user, showing the task that was marked as done.
     *
     * @param taskList the list of tasks where the task will be marked as completed.
     * @param ui the UI that handles the display of messages to the user.
     * @param storage the storage used to save the tasks (not used in this method).
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.complete(taskIndex);
        String response = "Nice! I've marked this task as done: \n" + taskList.print(taskIndex);
        return response;

    }
}
