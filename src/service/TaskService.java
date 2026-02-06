package service;

import domain.Task;
import domain.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    // Task 목록을 저장할 리스트
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    // Task 생성 - 기본 상태는 TODO
    public Task createTask(String description) {
        Task task = new Task(nextId++, description);
        tasks.add(task);
        return task;
    }

    // 모든 Task 조회
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    // 특정 상태의 Task 조회
    public List<Task> getTasksByStatus(TaskStatus status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus() == status) {
                result.add(task);
            }
        }
        return result;
    }

    // id로 Task 조회
    public Task getTaskById(long id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    // Task 완료 처리 - TODO 상태에서만 DONE으로 변경
    public boolean completeTask(long id) {
        Task task = getTaskById(id);
        if (task != null && task.getStatus() == TaskStatus.TODO) {
            task.complete();
            return true;
        }
        return false;
    }

    // Task 다시 열기 - DONE 상태에서만 TODO로 변경
    public boolean reopenTask(long id) {
        Task task = getTaskById(id);
        if (task != null && task.getStatus() == TaskStatus.DONE) {
            task.reopen();
            return true;
        }
        return false;
    }
}
