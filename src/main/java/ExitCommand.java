public class ExitCommand extends Command {

    public ExitCommand() {

    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printExit();
        storage.writeToFile(taskList);
        ui.printMessage("Task list has been saved");
        ui.colseScanner();
    }
}
