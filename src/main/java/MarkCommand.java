public class MarkCommand extends Command {
    private int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.complete(taskIndex);
        ui.printLine();
        ui.printMessage("Nice! I've marked this task as done: ");
        ui.printMessage(taskList.print(taskIndex));
        ui.printLine();
    }
}
