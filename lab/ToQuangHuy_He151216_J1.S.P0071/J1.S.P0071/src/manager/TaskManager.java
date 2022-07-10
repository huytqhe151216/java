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
import java.util.ArrayList;

/**
 * This class contains methods addTask, updateTask, deleteTask and getDataTasks
 * that can be used to add, update, delete, and getDataTasks assigned jobs.
 *
 * @author HuyTQ
 */
public class TaskManager {

    private final InputReader inputReader = new InputReader();
    private final Checker checker = new Checker();
    private final ArrayList<Task> taskList = new ArrayList<>(); // Initialize list to contain all task.
    private int id = 1;

    /**
     * This method add sample task to list.
     */
    private void addSampleDataTask() {
        taskList.add(new Task(id++, 1, "To Quang Huy", LocalDate.of(2021, 5, 12), 10f, 15f, "Name 1", "Lead"));
        taskList.add(new Task(id++, 4, "Nguyen The Vinh", LocalDate.of(2021, 6, 15), 8f, 17.5f, "Name 1", "Lead"));
        taskList.add(new Task(id++, 3, "Nguyen Van A", LocalDate.of(2021, 4, 9), 9f, 16f, "Name 2", "Lead"));
        taskList.add(new Task(id++, 2, "Nguyen Thi B", LocalDate.of(2021, 9, 20), 9f, 17f, "Name 2", "Lead"));
    }

    /**
     * This method will show the title of tasks
     */
    private void titleRow() {
        System.out.printf("|%-5s|%-25s|%-12s|%-20s|%-6s|%-20s|%-20s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
    }

    /**
     * This method get task object from list if it that object have same Id.
     *
     * @param id - id user input.
     * @return task object that have id.
     */
    private Task getTaskByID(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    /**
     * This method will ask the user to enter a new task assigned and add the
     * assigned task to the taskList
     *
     * @param taskList contains the tasks
     * @param id
     */
    private void addTask() {
        System.out.println("========== ADD TASK ==========");
        while (true) {
            String name = inputReader.getInputString("Task Name: ", 20); // enter name
            int taskTypeId = inputReader.getInputNumberInRange("Task Type: (1: Code, 2: Test, 3: Design, 4: Reviewer): ", 0, 4); // enter task type
            LocalDate date = inputReader.getInputDate("Date: ", 11); // enter the date 
            float planFrom = Float.parseFloat(inputReader.getInputPlanFrom("From (8.0 -> 17.5): ", false));
            float planTo;
            while (true) {
                planTo = Float.parseFloat(inputReader.getInputPlanTo("To (8.0 -> 17.5): ", false));
                if (planTo > planFrom) {
                    // make sure planTo>planFrom
                    break;
                }
                System.out.println("Plan To must be great than Plan From!");
            }
            String assign = inputReader.getInputString("Assignee: ", 20);
            String reviewer = inputReader.getInputString("Reviewer: ", 20);
            taskList.add(new Task(id, taskTypeId, name, date, planFrom, planTo, assign, reviewer)); // add new task
            System.out.println("========== Add task successfully ==========");
            id++; // increase the count of task
            if (inputReader.getInputYN("Do you want to continue add? (Y/N): ") == false) {
                return;
            }
        }
    }

    /**
     * This method update for taskTypeID when it in range [1,4]. If user input
     * nope , do nothing
     *
     * @param task - task user want to update
     * @return a type is code, test, design or review or nope.
     */
    private void updateTaskTypeId(Task task) {
        while (true) {
            String inputString = inputReader.getInputString("Task Type (1: Code, 2: Reviewer, 3: Test, 4: Design): ", 4);
            if (inputString.equalsIgnoreCase("nope")) {
                return;
            }
            if (checker.checkRangeNumber(inputString, 0, 4)) {
                task.setTaskTypeID(Integer.parseInt(inputString));
                return;
            }
        }
    }

    /**
     * This method update user input for Date when it is a valid date in format
     * "month-date-year". If user input nope remain information.
     *
     * @param task - task user want to update
     * @return a positive integer
     */
    private void updateDate(Task task) {
        while (true) {
            String inputDate = inputReader.getInputString("Date: ", 15);
            if (inputDate.equalsIgnoreCase("nope")) {
                return;
            }
            LocalDate date = checker.checkDate(inputDate);
            if (date != null) {
                task.setDate(date);
                return;
            }
        }
    }

    /**
     * This method the user can update the information of the assigned task
     * based on the ID number
     *
     * @param taskList contains the assigned task
     */
    private void updateTask() {
        System.out.println("========== Task Update ==========");
        if (taskList.isEmpty()) {
            // if the taskList is empty then notify
            System.err.println("List is empty.");
            return;
        }
        while (true) {
            int taskId = inputReader.getInputId("Enter ID: ", taskList);
            Task taskInfo = getTaskByID(taskId); // get task information to update
            System.out.printf("|%-5s|%-25s|%-12s|%-20s|%-6s|%-6s|%-6s|%-20s|%-20s\n",
                    "ID", "Name", "Task Type", "Date", "From", "To", "Time", "Assign", "Reviewer"); // show title bar
            taskInfo.displayTaskWithPlan();
            if (!inputReader.getInputYN("Do you want to continue update? (Y/N): ")) { // if user enters N then will stop update
                // if user enters N then cancel
                System.out.println("Update canceled");
                return;
            }
            String name = inputReader.getInputString("Task Name: ", 20); // enter name
            if (!name.equalsIgnoreCase("nope")) {
                taskInfo.setRequirementName(name); // update if name !=nope
            }
            updateTaskTypeId(taskInfo);
            updateDate(taskInfo);
            float planFrom = Float.parseFloat(inputReader.getInputPlanFrom("From (ex: 8.0 -> 17.5): ", true)); // enter planFrom
            float planTo = Float.parseFloat(inputReader.getInputPlanTo("To (ex: 8.0 -> 17.5): ", true)); // enter planTo
            while (true) {
                if ((planFrom == -1) && (planTo != -1) && (planTo <= taskInfo.getPlanFrom())) {
                    // if skip planFrom and enter planTo then check planTo vs planFrom
                    System.out.println("planTo must be greate than " + taskInfo.getPlanFrom() + ". Re-enter!");
                    planTo = Float.parseFloat(inputReader.getInputPlanTo("To (ex: 8.0 -> 17.5): ", true));
                } else if ((planFrom != -1) && (planTo == -1) && (planFrom >= taskInfo.getPlanTo())) {
                    // if enter planFrom and skip planTo then check planFrom vs planTo
                    System.out.println("planFrom must be less than " + taskInfo.getPlanTo() + ". Re-enter!");
                    planFrom = Float.parseFloat(inputReader.getInputPlanFrom("To (ex: 8.0 -> 17.5): ", true));
                } else if ((planFrom != -1) && (planTo != -1) && (planTo < planFrom)) {
                    // if enter planFrom and planTo then check planFrom vs planTo
                    System.out.println("planTo must be greater than planFrom. Re-enter!");
                    planFrom = Float.parseFloat(inputReader.getInputPlanFrom("To (ex: 8.0 -> 17.5): ", true));
                    planTo = Float.parseFloat(inputReader.getInputPlanTo("To (ex: 8.0 -> 17.5): ", true));
                } else {
                    // if planFrom < planTo then stop
                    break;
                }
            }
            if (planFrom != -1) {
                taskInfo.setPlanFrom(planFrom); // update if planFrom !=-1
            }
            if (planTo != -1) {
                taskInfo.setPlanTo(planTo); // update if planTo !=-1
            }
            String assign = inputReader.getInputString("Assignee: ", 20); // enter assignee
            if (!assign.equalsIgnoreCase("nope")) {
                taskInfo.setAssign(assign); // update if assign !=nope
            }
            String reviewer = inputReader.getInputString("Reviewer: ", 20); // enter reviewer
            if (!reviewer.equalsIgnoreCase("nope")) {
                taskInfo.setReviewer(reviewer); // update if reviewer !=nope
            }
            System.out.println("Update successful");
            if (!inputReader.getInputYN("Do you want to continue update? (Y/N): ")) { // if user enters N then will stop update
                return;
            }
        }
    }

    /**
     * This method user can delete assigned task based on ID number
     *
     * @param taskList contains the assigned task
     */
    private void deleteTask() {
        System.out.println("=========== Task Delete ===========");
        if (taskList.isEmpty()) {//isEmpty do nothing
            System.err.println("List is empty.");
            return;
        }
        int taskID = inputReader.getInputId("Enter ID: ", taskList); // enter id number
        Task task = getTaskByID(taskID);
        titleRow();
        task.displayTask();
        if (!inputReader.getInputYN("Do you want to continue delete? (Y/N): ")) {
            System.out.println("Delete canceled");
            return;
        }
        taskList.remove(task);
        System.out.println("Delete " + task.getId() + " successfully");
        if (!inputReader.getInputYN("Do you want to continue delete? (Y/N): ")) {
            System.out.println("Delete canceled");
        }
    }

    /**
     * This method will getDataTasks information about the assigned tasks
     *
     * @param taskList contains the assigned task
     */
    private void getDataTasks() {
        System.out.println("=========== Task List ===========");
        if (taskList.isEmpty()) {//empty do nothing.
            System.err.println("List is empty.");
            return;
        }
        titleRow(); // Show the title of tasks
        for (int i = taskList.size() - 1; i >= 0; i--) {
            taskList.get(i).displayTask();
        }
    }

    /**
     * This method will display the information to add, update, delete,
     * getDataTasks and return the corresponding function
     *
     */
    private void displayMainScreen() {
        Task task = new Task();
        task.addTaskType();
        addSampleDataTask();
        while (true) {
            System.out.println("=========== Task program ===========");
            System.out.println("    1.  Add Task");
            System.out.println("    2.  Update Task");
            System.out.println("    3.  Delete Task");
            System.out.println("    4.  Display Task");
            System.out.println("    0.  Exit");
            int choice = inputReader.getInputNumberInRange("> Enter choice: ", 0, 4);
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    updateTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    getDataTasks();
                    break;
                case 0:
                    return;
            }
        }
    }

    /**
     * This is a main method have an Object to call SelectionSort methods and
     * run the program.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.displayMainScreen();
    }
}
