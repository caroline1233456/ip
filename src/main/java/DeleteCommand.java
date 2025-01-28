public class DeleteCommand extends Command{
    private int taskIndex;
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task deletedTask = taskList.delete(taskIndex);
        ui.printLine();
        ui.printMessage("Noted. I've removed this task:");
        ui.printMessage(deletedTask.toString());
        ui.printMessage("Now you have " + taskList.getSize() + " tasks in the list");
        ui.printLine();
    }
}
