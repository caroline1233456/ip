package parakeet.task;

import parakeet.task.Task;
import parakeet.task.TaskType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDateTime deadline;
    public Deadline(boolean isDone, String description, LocalDateTime deadline) {

        super(isDone, description, TaskType.DEADLINE);
        this.deadline = deadline;
    }
    @Override
    public String convertToFileFormat() {
        String str = "D | " + (super.isDone? "1": "0")
                + " | " + super.description + " | "
                +  this.deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm")) + " | 0 ";
        return str;
    }
    @Override
    public String toString() {
        String str = "[D]";
        str = str + super.toString() + " (by: "
                + this.deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm")) + ")";
        return str;
    }
}
