/* Ejemplo Lista de To-do */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TodoListTest {

    private TodoList todoList;

    @BeforeEach
    public void setUp() {
        todoList = new TodoList();
    }

    @Test
    public void testAddTask() {
        todoList.addTask("Learn TDD");
        assertEquals(1, todoList.getPendingTasks().size());
    }

    @Test
    public void testCompleteTask() {
        todoList.addTask("Learn TDD");
        todoList.completeTask("Learn TDD");
        assertEquals(0, todoList.getPendingTasks().size());
    }

    @Test
    public void testGetPendingTasks() {
        todoList.addTask("Learn TDD");
        todoList.addTask("Write tests");
        todoList.completeTask("Learn TDD");
        List<String> pendingTasks = todoList.getPendingTasks();
        assertEquals(1, pendingTasks.size());
        assertTrue(pendingTasks.contains("Write tests"));
    }
}
