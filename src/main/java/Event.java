public class Event extends Task{
    private String from;
    private String to;
    public Event(boolean isDone, String task, String from, String to) {

        super(isDone,task);
        this.from = from;
        this.to = to;
    }
    @Override
    public String toString() {
        String str = "[E]";
        str = str + super.toString() + " (from: " + from + " to: " + to + ")";
        return str;
    }
}
