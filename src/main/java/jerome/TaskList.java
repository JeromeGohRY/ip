package jerome;

import jerome.task.Task;

import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void add(Task task) {
        this.tasks.add(task);
    }

    public Task remove(int index) {
        return this.tasks.remove(index);
    }

    public int size() {
        return this.tasks.size();
    }

    public Task get(int index) throws JeromeException {
        try {
            return this.tasks.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new JeromeException("Please provide a valid index");
        }
    }

    public ArrayList<Task> getAll() {
        return this.tasks;
    }

    public void filter(String keyword) {
        TaskList matches = new TaskList(new ArrayList<Task>());
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getDescription().contains(keyword)) {
                matches.add(this.tasks.get(i));
            }
        }
        System.out.println("Here are the matching tasks in your list:");
        matches.listTasks();

    }

    public void listTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". " + this.tasks.get(i));
        }
    }
}
