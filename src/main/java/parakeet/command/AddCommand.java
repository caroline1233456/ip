package parakeet.command;


import parakeet.TaskList;
import parakeet.Ui;
import parakeet.Storage;

public abstract class AddCommand extends Command {


    public abstract void execute(TaskList taskList, Ui ui, Storage storage);
}
