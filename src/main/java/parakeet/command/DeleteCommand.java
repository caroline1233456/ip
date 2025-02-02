package parakeet.command;

import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;
import parakeet.task.Deadline;
import parakeet.task.Task;


public class DeleteCommand extends Command {
    private int taskIndex;
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Deletes the task at the specified index from the task list.
     * Sends a confirmation message displaying the task that was removed and the updated task count.
     *
     * @param taskList The list of tasks where the task will be deleted from.
     * @param ui The UI that handles displaying messages to the user.
     * @param storage The storage used to save the tasks (not used in this method).
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        Task deletedTask = taskList.delete(taskIndex);
        String response = "Noted. I've removed this task: \n" + deletedTask.toString() + "\n"
                + "Now you have " + taskList.getSize()+ " tasks in the list";
        return response;
    }
}
