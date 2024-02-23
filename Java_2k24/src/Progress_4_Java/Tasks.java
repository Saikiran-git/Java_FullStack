package Progress_4_Java;

public class Tasks {
    private String taskId;
    private String taskName;
    private String assignee;

    public Tasks(String taskId, String taskName, String assignee) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.assignee = assignee;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setAssignedTo(String assignee) {
        this.assignee = assignee;
    }
}
