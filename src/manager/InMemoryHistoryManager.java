package manager;

import model.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private HashMap<Integer, Node> taskMap = new HashMap<>();
    private Node head;
    private Node tail;

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
        List<Task> history = new ArrayList<>();
        for (Node node = head; node != null; node = node.next) {
            history.add(node.task);
        }
        return history;
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