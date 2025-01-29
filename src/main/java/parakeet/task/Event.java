package parakeet.task;

import parakeet.task.Task;
import parakeet.task.TaskType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;
    public Event(boolean isDone, String description, LocalDateTime from, LocalDateTime to) {

        super(isDone, description, TaskType.EVENT);
        this.from = from;
        this.to = to;
    }
    @Override
    public String convertToFileFormat() {
        String str = "E | " + (super.isDone? "1": "0") + " | " + super.description
                + " | " + this.from. format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm")) + " | "
                + this.to. format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"));
        return str;
    }

    @Override
    public String toString() {
        String str = "[E]";
        str = str + super.toString() + " (from: " + from. format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"))
                + " to: " + to. format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"))
                + ")";
        return str;
    }
}
