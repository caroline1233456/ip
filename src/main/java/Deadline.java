import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    private LocalDate deadline;
    public Deadline(boolean isDone, String description, LocalDate deadline) {

        super(isDone, description, TaskType.DEADLINE);
        this.deadline = deadline;
    }
    @Override
    public String convertToFileFormat() {
        String str = "D | " + (super.isDone? "1": "0")
                + " | " + super.description + " | "
                +  this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " | 0 ";
        return str;
    }
    @Override
    public String toString() {
        String str = "[D]";
        str = str + super.toString() + " (by: "
                + this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
        return str;
    }
}
