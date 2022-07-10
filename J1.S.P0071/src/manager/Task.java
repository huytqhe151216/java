
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Task {

    private int id;
    private TaskType taskType;
    private String requirementName;
    private LocalDate date;
    private float planFrom;
    private float planTo;
    private String assign;
    private String reviewer;

    public Task() {
    }

    public Task(int id, int taskTypeId, String requirementName, LocalDate date, float flanFrom, float planTo, String assign, String reviewer) {
        this.id = id;
        this.taskType = getTaskTypeByID(taskTypeId);
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = flanFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    private static final ArrayList<TaskType> TASKTYPES = new ArrayList<>();

    public void addTaskType() {
        TASKTYPES.add(new TaskType(1, "Code"));
        TASKTYPES.add(new TaskType(2, "Review"));
        TASKTYPES.add(new TaskType(3, "Test"));
        TASKTYPES.add(new TaskType(4, "Design"));
    }

    private TaskType getTaskTypeByID(int TaskTypeID) {
        for (int i = 0; i < TASKTYPES.size(); i++) {
            if (TASKTYPES.get(i).getTaskTypeID() == TaskTypeID) {
                return TASKTYPES.get(i);
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(float planFrom) {
        this.planFrom = planFrom;
    }

    public float getPlanTo() {
        return planTo;
    }

    public void setPlanTo(float planTo) {
        this.planTo = planTo;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    public void setTaskTypeID(int taskType) {
        this.taskType = getTaskTypeByID(taskType);
    }
    public void displayTask() {
        System.out.printf("|%-5d|%-25s|%-12s|%-20s|%-6.1f|%-20s|%-20s\n", id, requirementName, taskType.getTaskType(),
                date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")), planTo - planFrom, assign, reviewer);
    }

    public void displayTaskIncludePlan() {
        System.out.printf("|%-5s|%-25s|%-12s|%-20s|%-6s|%-6s|%-6s|%-20s|%-20s\n", id, requirementName, taskType.getTaskType(),
                date.format(DateTimeFormatter.ofPattern("dd-MMM-YYYY")), planFrom, planTo, planTo - planFrom, assign, reviewer);
    }
    
}
