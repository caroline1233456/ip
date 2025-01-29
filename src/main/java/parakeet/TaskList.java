package parakeet;

import parakeet.task.Task;

import java.util.ArrayList;

public class TaskList {
    public ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }
    public void complete(int index) {
        this.taskList.get(index).complete();
    }

    public void unDone(int index) {
        this.taskList.get(index).unDone();
    }

    public Task delete(int index) {
        Task deletedTask = taskList.get(index);
        taskList.remove(index);
        return deletedTask;
    }
    public String print(int index) {
        return this.taskList.get(index).toString();
    }

    public int getSize() {
        return this.taskList.size();
    }

    public void add(Task newTask) {
        this.taskList.add(newTask);
    }

    public String convertToFileFormat() {
        String str = "";
        for (int i =0; i < taskList.size(); i++) {
            str = str + taskList.get(i).convertToFileFormat() + System.lineSeparator();
        }
        return str;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < taskList.size(); i++) {
            str = str + ( i + 1 )+ "." + taskList.get(i).toString() + System.lineSeparator();
        }
        return str;
    }

}
