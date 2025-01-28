public class TodoCommand extends AddCommand {
    private String taskDescription;

    public TodoCommand(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task newTask = new Todo(false, this.taskDescription);
        taskList.add(newTask);
        ui.printLine();
        ui.printMessage("Got it. I've added this task: ");
        ui.printMessage(newTask.toString());
        ui.printMessage("Now you have " + taskList.getSize() + " tasks in the list");
        ui.printLine();
    }
}
