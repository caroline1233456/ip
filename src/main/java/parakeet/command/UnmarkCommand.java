package parakeet.command;


import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;

public class UnmarkCommand extends Command {
    private int taskIndex;
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Marks the task at the specified index as completed.
     * Sends a confirmation message displaying the task marked as done.
     *
     * @param taskList List of tasks where the task is to be marked as completed.
     * @param ui The UI that handles displaying messages to the user.
     * @param storage The storage used to save the tasks (not used in this method).
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.unDone(taskIndex);

        String response = "Ok, I've marked this task as not done yet: \n" + taskList.print(taskIndex);
        return response;

    }
}
