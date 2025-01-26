public class Event extends Task{
    private String from;
    private String to;
    public Event(boolean isDone, String description, String from, String to) {

        super(isDone, description, TaskType.EVENT);
        this.from = from;
        this.to = to;
    }
    @Override
    public String convertToFileFormat() {
        String str = "E | " + (super.isDone? "1": "0") + " | " + super.description + " | " + this.from + " | " + this.to;
        return str;
    }
    @Override
    public String toString() {
        String str = "[E]";
        str = str + super.toString() + " (from: " + from + " to: " + to + ")";
        return str;
    }
}
