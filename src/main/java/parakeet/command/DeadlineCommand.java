package parakeet.command;

import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;
import parakeet.task.Deadline;
import parakeet.task.Task;

import java.time.LocalDateTime;

public class DeadlineCommand extends AddCommand {
    private String description;
    private LocalDateTime deadline;

    public DeadlineCommand(String description, LocalDateTime deadline) {
        this.deadline = deadline;
        this.description = description;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task newDeadline = new Deadline(false, description, deadline);
        taskList.add(newDeadline);
        ui.printLine();
        ui.printMessage("Got it. I've added this task: ");
        ui.printMessage(newDeadline.toString());
        ui.printMessage("Now you have " + taskList.getSize()+ " tasks in the list");
        ui.printLine();
    }
}
