package Progress_4_Java;

import java.util.*;

public interface TaskDAO {
    void addTask(Tasks task);
    Tasks getTask(String taskId);
    void updateTask(Tasks task);
    void deleteTask(String taskId);
    List<Tasks> searchTasks(String keyword);
}