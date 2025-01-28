public class UnmarkCommand extends Command {
    private int taskIndex;
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.unDone(taskIndex);
        ui.printLine();
        ui.printMessage("Ok, I've marked this task as not done yet: ");
        ui.printMessage(taskList.print(taskIndex));
        ui.printLine();
    }
}
