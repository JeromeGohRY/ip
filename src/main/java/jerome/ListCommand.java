package jerome;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.listTasks();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
