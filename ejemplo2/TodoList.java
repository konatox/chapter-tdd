import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<String> tasks = new ArrayList<>();
    private List<String> completedTasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void completeTask(String task) {
        if (tasks.remove(task)) {
            completedTasks.add(task);
        }
    }

    public List<String> getPendingTasks() {
        return new ArrayList<>(tasks);
    }
}
