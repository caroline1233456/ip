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
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task newEvent = new Event(false, description, startTime, endTime);
        taskList.add(newEvent);
        ui.printLine();
        ui.printMessage("Got it. I've added this task: ");
        ui.printMessage(newEvent.toString());
        ui.printMessage("Now you have " + taskList.getSize() + " tasks in the list");
        ui.printLine();
    }
}
