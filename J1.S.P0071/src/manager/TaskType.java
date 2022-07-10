/*
 * Copyright(C) 2021, FPT university
 * J1.S.P0071
 * Task Manager
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-11-05      1.0                 HuyTQ            First Implement
 */
package manager;

/**
 *This  class describe task of an employee, contain 2 attributes:taskTypeID and taskType.
 * 
 * @author HUYTQ
 */
public class TaskType {

    private int taskTypeID;
    private String taskType;

    public TaskType() {
    }

    public TaskType(int taskTypeID, String taskType) {
        this.taskTypeID = taskTypeID;
        this.taskType = taskType;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public String getTaskType() {
        return taskType;
    }

}
