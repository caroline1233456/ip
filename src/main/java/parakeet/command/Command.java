package parakeet.command;

import parakeet.Storage;
import parakeet.TaskList;
import parakeet.Ui;

public abstract class Command {

    public abstract void execute(TaskList taskList, Ui ui, Storage storage);
}
