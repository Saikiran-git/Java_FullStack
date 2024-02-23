package Progress_4_Java;

import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    private ArrayList<Tasks> tasks = new ArrayList<>();

    @Override
    public void addTask(Tasks task) {
        tasks.add(task);
    }

    @Override
    public Tasks getTask(String taskId) {
        for (Tasks task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public void updateTask(Tasks task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskId().equals(task.getTaskId())) {
                tasks.set(i, task);
                break;
            }
        }
    }

    @Override
    public void deleteTask(String taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskId().equals(taskId)) {
                tasks.remove(i);
                break;
            }
        }
    }


    @Override
    public List<Tasks> searchTasks(String keyword) {
        List<Tasks> filteredTasks = new ArrayList<>();
        for (Tasks task : tasks) {
            if (task.getTaskName().contains(keyword)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

}
