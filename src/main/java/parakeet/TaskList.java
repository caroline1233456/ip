package parakeet;

import parakeet.task.Task;

import java.util.ArrayList;


/**
 * The {@code TaskList} class represents a collection of tasks. It provides
 * methods to manipulate the list of tasks such as completing, marking as undone,
 * deleting tasks, and converting the list to a file-friendly format.
 */
public class TaskList {
    public ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Marks the task at taskList[index] as completed
     *
     * @param index the index in taskList.
     */
    public void complete(int index) {
        this.taskList.get(index).complete();
    }

    /**
     * Marks the task at specific index as undone
     *
     * @param index the index the task is at in taskList.
     */
    public void unDone(int index) {
        this.taskList.get(index).unDone();
    }

    /**
     *Deletes the task at specific index
     *
     * @param index the index of the  task to be deleted.
     * @return the task deleted.
     */
    public Task delete(int index) {
        Task deletedTask = taskList.get(index);
        taskList.remove(index);
        return deletedTask;
    }

    /**
     * Returns a string representation of the task at the specified index.
     *
     * @param index the index of the task to be printed.
     * @return the string representation of the task at the specified index.
     */
    public String print(int index) {
        return this.taskList.get(index).toString();
    }

    /**
     * Returns the size of the taskList
     *
     * @return the size of the taskList.
     */
    public int getSize() {
        return this.taskList.size();
    }

    /**
     * Adds a new task to the task list.
     *
     * @param newTask the task to be added to the list.
     */
    public void add(Task newTask) {
        this.taskList.add(newTask);
    }

    /**
     * Converts the task list to a file-friendly format by calling each task's
     * {@code convertToFileFormat} method. The tasks are separated by new lines.
     *
     * @return a string representation of the task list in file format.
     */
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
