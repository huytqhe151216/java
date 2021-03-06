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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The class contains attribute of Task object and getter,setter,display object.
 *
 * @author HuyTQ
 */
public class Task {

    private static final ArrayList<TaskType> TASKTYPES = new ArrayList<>();

    private int id;
    private TaskType taskType;
    private String requirementName;
    private LocalDate date;
    private float planFrom;
    private float planTo;
    private String assign;
    private String reviewer;

    /**
     * default constructor.
     */
    public Task() {
    }

    /**
     * Constructor with its parameters:
     *
     * @param id : Task ID
     * @param taskTypeId : Task Type
     * @param requirementName - Task Name
     * @param date : Date of birth
     * @param planFrom : From time
     * @param planTo : To time
     * @param assign : Task assignee
     * @param reviewer : Reviewer
     */
    public Task(int id, int taskTypeId, String requirementName, LocalDate date, float planFrom, float planTo, String assign, String reviewer) {
        this.id = id;
        this.taskType = getTaskTypeByID(taskTypeId);
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    /**
     * 4 default task types.
     */
    public void addTaskType() {
        TASKTYPES.add(new TaskType(1, "Code"));
        TASKTYPES.add(new TaskType(2, "Review"));
        TASKTYPES.add(new TaskType(3, "Test"));
        TASKTYPES.add(new TaskType(4, "Design"));
    }

    /**
     * This method get task object by using ID
     *
     * @param taskTypeId - id user input.
     * @return TaskType object that have paramID.
     */
    private TaskType getTaskTypeByID(int taskTypeId) {
        for (int i = 0; i < TASKTYPES.size(); i++) {
            if (TASKTYPES.get(i).getTaskTypeID() == taskTypeId) {
                return TASKTYPES.get(i);
            }
        }
        return null;
    }

    /**
     * This method get task ID and return it.
     *
     * @return integer that is task ID.
     */
    public int getId() {
        return id;
    }

    /**
     * This method use to set task ID.
     *
     * @param id task ID want to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method get Task type and return it.
     *
     * @return a string that is Task type.
     */
    public TaskType getTaskTypeId() {
        return taskType;
    }

    /**
     * This method use to set Task type.
     *
     * @param taskType taskType object
     */
    public void setTaskTypeID(int taskType) {
        this.taskType = getTaskTypeByID(taskType);
    }

    /**
     * This method get name and return it.
     *
     * @return String that is task name.
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * This method use to set task name.
     *
     * @param requirementName task name want to set
     */
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    /**
     * This method get date and return it.
     *
     * @return String that in Date format.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * This method use to set date.
     *
     * @param date in format.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * This method get from time and return it.
     *
     * @return real number is from time.
     */
    public float getPlanFrom() {
        return planFrom;
    }

    /**
     * This method use to set time from.
     *
     * @param planFrom From time want to set
     */
    public void setPlanFrom(float planFrom) {
        this.planFrom = planFrom;
    }

    /**
     * This method get to time and return it.
     *
     * @return real number is to time.
     */
    public float getPlanTo() {
        return planTo;
    }

    /**
     * This method use to set to time.
     *
     * @param planTo to time want to set
     */
    public void setPlanTo(float planTo) {
        this.planTo = planTo;
    }

    /**
     * This method get assignee and return it.
     *
     * @return String that is assignee.
     */
    public String getAssign() {
        return assign;
    }

    /**
     * This method use to set assignee.
     *
     * @param assign assignee want to set
     */
    public void setAssign(String assign) {
        this.assign = assign;
    }

    /**
     * This method get reviewer name and return it.
     *
     * @return string that is reviewer name.
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * This method use to set reviewer name.
     *
     * @param reviewer reviewer name want to set
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    /**
     * This method to display information of task assigned
     */
    public void displayTask() {
        System.out.printf("|%-5d|%-25s|%-12s|%-20s|%-6.1f|%-20s|%-20s\n", id, requirementName, taskType.getTaskType(),
                date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")), planTo - planFrom, assign, reviewer);
    }

    /**
     * This method to display information of task assigned contain planFrom and
     * planTo
     */
    public void displayTaskWithPlan() {
        System.out.printf("|%-5s|%-25s|%-12s|%-20s|%-6s|%-6s|%-6s|%-20s|%-20s\n", id, requirementName, taskType.getTaskType(),
                date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")), planFrom, planTo, planTo - planFrom, assign, reviewer);
    }
}
