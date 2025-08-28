package jerome.command;

import jerome.Storage;
import jerome.TaskList;
import jerome.Ui;
import jerome.task.Task;
import jerome.task.Todo;

public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = new Todo(description);
        tasks.add(task);
        ui.showAddition(task,tasks);
        storage.save(tasks.getAll());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
