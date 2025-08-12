package manager;

import model.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private static final int MAX_HISTORY_STORAGE = 10;
    private final LinkedList<Task> historyList = new LinkedList<>();

    @Override
    public void add(Task task) {
        if (task == null) {
            return;
        }
        if (historyList.size() == MAX_HISTORY_STORAGE) {
            historyList.removeFirst();
        }
        historyList.add(task);
    }

    @Override
    public List<Task> getHistory() {
        return new LinkedList<>(historyList);
    }

    class Node {
        Task task;
        Node prev;
        Node next;

        Node(Task task) {
            this.task = task;
            prev = null;
            next = null;
        }
    }
}

}