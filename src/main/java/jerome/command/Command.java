package jerome.command;

import jerome.JeromeException;
import jerome.Storage;
import jerome.TaskList;
import jerome.Ui;

public abstract class Command {
    public abstract boolean isExit();
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws JeromeException;
}
