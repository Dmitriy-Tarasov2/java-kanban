package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.Task;
import java.util.List;


public class InMemoryHistoryManagerTest {
    private HistoryManager historyManager;

    @BeforeEach
    public void setUp() {
        historyManager = new InMemoryHistoryManager();
    }

    @Test
    public void testAddTaskToHistory() {
        Task task = new Task("Test task", "Description");
        historyManager.add(task);
        assertEquals(1, historyManager.getHistory().size());
        assertTrue(historyManager.getHistory().contains(task));
    }

    @Test
    public void testRemoveTaskFromHistory() {
        Task task = new Task("Test task", "Description");
        historyManager.add(task);
        historyManager.remove(task.getId());
        assertEquals(0, historyManager.getHistory().size());
    }

    @Test
    public void testGetHistory() {
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 2", "Description 2");
        historyManager.add(task1);
        historyManager.add(task2);
        List<Task> history = historyManager.getHistory();
        assertEquals(2, history.size());
        assertTrue(history.contains(task1));
        assertTrue(history.contains(task2));
    }
}

