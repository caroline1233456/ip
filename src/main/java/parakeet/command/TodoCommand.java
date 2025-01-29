package parakeet.command;


import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;
import parakeet.task.Task;
import parakeet.task.Todo;
public class TodoCommand extends AddCommand {
    private String taskDescription;

    public TodoCommand(String taskDescription) {
        this.taskDescription = taskDescription;
    }


    /**
     * Executes the command to add a Todo task to the task list.
     * This method creates a new {@link Todo} task with the specified description,
     * adds it to the task list, and updates the UI with the details of the new task
     * and the total number of tasks.
     *
     * @param taskList the list of tasks to add the Todo task to.
     * @param ui the UI that handles the display of messages to the user.
     * @param storage the storage used to save the tasks (not used in this method).
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task newTask = new Todo(false, this.taskDescription);
        taskList.add(newTask);
        ui.printLine();
        ui.printMessage("Got it. I've added this task: ");
        ui.printMessage(newTask.toString());
        ui.printMessage("Now you have " + taskList.getSize() + " tasks in the list");
        ui.printLine();
    }
}
