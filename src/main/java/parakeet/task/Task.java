package parakeet.task;

public abstract class Task {
    public boolean isDone;
    public String description;

    private TaskType taskType;

    public Task(boolean isDone, String description, TaskType taskType) {
        this.isDone = isDone;
        this.description = description;
        this.taskType = taskType;
    }

    public void complete() {
        this.isDone = true;
    }

    public void unDone() {
        this.isDone = false;
    }

    public abstract String convertToFileFormat();

    @Override
    public String toString() {
        String str = "[";
        if(isDone) {
            str = str + "X";
        }
        str = str + "] " + description;
        return str;
    }
}
