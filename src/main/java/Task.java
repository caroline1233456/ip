public class Task {
    private boolean isDone;
    private String task;

    public Task(boolean isDone, String task) {
        this.isDone = isDone;
        this.task = task;
    }

    public void complete() {
        this.isDone = true;
    }

    public void unDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        String str = "[";
        if(isDone) {
            str = str + "X";
        }
        str = str + "] " + task;
        return str;
    }
}
