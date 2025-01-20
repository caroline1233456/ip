public class Deadline extends Task{
    private String deadline;
    public Deadline(boolean isDone, String task,String deadline) {

        super(isDone,task);
        this.deadline = deadline;
    }
    @Override
    public String toString() {
        String str = "[D] ";
        str = str + super.toString() + " (by: " + deadline + ")";
        return str;
    }
}
