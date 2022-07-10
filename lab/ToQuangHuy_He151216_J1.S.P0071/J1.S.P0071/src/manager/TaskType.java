/*
 * Copyright(C) 2021, To Quang Huy
 * J1.S.P0071
 * Task Manager
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-11-06        1.0               HuyTQ            First Implement
 */
package manager;

/**
 * This class describe task type of a employee such as taskTypeID and its name.
 *
 * @author HuyTQ
 */
public class TaskType {

    private int taskTypeID;
    private String taskType;

    /**
     * This is a default constructor with no parameters
     */
    public TaskType() {
    }

    /**
     * Constructor with 2 parameters.
     *
     * @param taskTypeID : id of task type
     * @param taskType : name of task type
     */
    public TaskType(int taskTypeID, String taskType) {
        this.taskTypeID = taskTypeID;
        this.taskType = taskType;
    }

    /**
     * This method get Task type ID and return
     *
     * @return ID of Type
     */
    public int getTaskTypeID() {
        return taskTypeID;
    }

    /**
     * This method get name of Task type and return it.
     *
     * @return taskType
     */
    public String getTaskType() {
        return taskType;
    }

}
