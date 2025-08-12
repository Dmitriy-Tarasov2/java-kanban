package manager;

import model.Task;
import java.util.*;

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

    @Override
    public void remove(int id) {
        Iterator<Task> iterator = historyList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

}