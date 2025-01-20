public class Event extends Task{
    public Event(boolean isDone, String task) {

        super(isDone,task);
    }
    @Override
    public String toString() {
        String str = "[E] ";
        str = str + super.toString();
        return str;
    }
}
