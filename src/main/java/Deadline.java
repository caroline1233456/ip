public class Deadline extends Task{
    private String deadline;
    public Deadline(boolean isDone, String description, String deadline) {

        super(isDone, description, TaskType.DEADLINE);
        this.deadline = deadline;
    }
    @Override
    public String convertToFileFormat() {
        String str = "D | " + (super.isDone? "1": "0") + " | " + super.description + " | " +  this.deadline + " | 0 ";
        return str;
    }
    @Override
    public String toString() {
        String str = "[D]";
        str = str + super.toString() + " (by: " + deadline + ")";
        return str;
    }
}
