public class Deadline extends Task{
    public Deadline(boolean isDone, String task) {
        super(isDone,task);
    }
    @Override
    public String toString() {
        String str = "[D] ";
        str = str + super.toString();
        return str;
    }
}
