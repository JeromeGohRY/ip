package jerome;

import jerome.command.Command;

public class Jerome {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Jerome(String path) {
        this.ui = new Ui();
        this.storage = new Storage(path);
        this.tasks = new TaskList(this.storage.load());
    }

    public static void main(String[] args) {
        new Jerome("data.txt").run();
    }

    public void run() {
        this.ui.hello();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = this.ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(this.tasks, this.ui, this.storage);
                isExit = c.isExit();
            } catch (JeromeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
