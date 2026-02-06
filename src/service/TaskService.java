package service;

import domain.Task;
import java.util.List;
import java.util.ArrayList;

public class TaskService {
    // Task 목록을 저장할 리스트
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    // Task 생성 - Task의 생성자만 사용
    public Task createTask(String description) {
        Task task = new Task(nextId++, description);
        tasks.add(task);
        return task;
    }

    // 모든 Task 조회
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    // id로 Task 조회 - getter만 사용
    public Task getTaskById(long id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    // Task 완료 처리 - Task의 complete(), isCompleted()만 사용
    public boolean completeTask(long id) {
        Task task = getTaskById(id);
        if (task != null && !task.isCompleted()) {
            task.complete();
            return true;
        }
        return false;
    }
}
