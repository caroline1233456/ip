public class Todo extends Task{
    public Todo(boolean isDone, String task) {
        super(isDone,task);
    }

    @Override
    public String toString() {
       String str = "[T]";
       str = str + super.toString();
       return str;
    }

}
