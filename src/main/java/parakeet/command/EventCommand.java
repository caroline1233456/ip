package parakeet.command;

import parakeet.command.AddCommand;

import java.time.LocalDateTime;
import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;
import parakeet.task.Event;
import parakeet.task.Task;
public class EventCommand extends AddCommand {
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public EventCommand(String description, LocalDateTime startTime, LocalDateTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Executes the command to add an Event task to the task list.
     * This method creates a new {@link Event} task with the specified description,
     * start time, and end time, adds it to the task list, and updates the UI with
     * the details of the new task and the total number of tasks.
     *
     * @param taskList the list of tasks to add the event to.
     * @param ui the UI that handles the display of messages to the user.
     * @param storage the storage used to save the tasks (not used in this method).
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        Task newEvent = new Event(false, description, startTime, endTime);
        taskList.add(newEvent);

        String response = "Got it. I've added this task: \n" + newEvent.toString() + "\n"
                + "Now you have " + taskList.getSize()+ " tasks in the list";
        return response;

    }
}
