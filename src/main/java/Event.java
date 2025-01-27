import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    private LocalDate from;
    private LocalDate to;
    public Event(boolean isDone, String description, LocalDate from, LocalDate to) {

        super(isDone, description, TaskType.EVENT);
        this.from = from;
        this.to = to;
    }
    @Override
    public String convertToFileFormat() {
        String str = "E | " + (super.isDone? "1": "0") + " | " + super.description
                + " | " + this.from. format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " | "
                + this.to. format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return str;
    }

    @Override
    public String toString() {
        String str = "[E]";
        str = str + super.toString() + " (from: " + from. format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + " to: " + to. format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + ")";
        return str;
    }
}
