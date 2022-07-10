
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
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class TaskManager {

    private int id = 1;
    private final ArrayList<Task> taskList = new ArrayList<>();
    private Checker checker = new Checker();
    private InputReader inputReader = new InputReader();

    private void titleRow() {
        System.out.printf("|%-5s|%-25s|%-12s|%-20s|%-6s|%-20s|%-20s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
    }

    private void displayMainScreen() {
        Task task = new Task();
        task.addTaskType();
        addSampleDataTask();
        while (true) {
            System.out.println("========== Task program ==========");
            System.out.println("    1.  Add Task");
            System.out.println("    2.  Update Task");
            System.out.println("    3.  Delete Task");
            System.out.println("    4.  Display Task");
            System.out.println("    0.  Exit");
            int choice = inputReader.getInputNumberInRange("> Enter choice: ", 0, 4);
            switch (choice) {
                case 1:
                    addTask(); // add task
                    break;
                case 2:
                    updateTask(); // update task
                    break;
                case 3:
                    deleteTask(); // delete task
                    break;
                case 4:
                    getDataTasks(); // get data tasks
                    break;
                case 0:
                    return;
            }
        }
    }

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
            taskInfo.displayTaskIncludePlan();
            if (!inputReader.getInputYesNo("Do you want to continue update? (Y/N): ")) { // if user enters N then will stop update
                // if user enters N then cancel
                System.out.println("Update canceled");
                return;
            }
            String name = inputReader.getInputString("Task Name: ", 20); // enter name
            if (!name.equalsIgnoreCase("nope")) {
                taskInfo.setRequirementName(name); // update if name !=null
            }
            updateTaskTypeId(taskInfo);
            updateDate(taskInfo);
            float planFrom = Float.parseFloat(inputReader.getInputPlanFrom("From (ex: 8.0 -> 17.5): ", true)); // enter start time
            float planTo = Float.parseFloat(inputReader.getInputPlanTo("To (ex: 8.0 -> 17.5): ", true)); // enter end time
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
                taskInfo.setPlanFrom(planFrom); // update if planFrom !=0
            }
            if (planTo != -1) {
                taskInfo.setPlanTo(planTo); // update if planTo !=0
            }
            String assign = inputReader.getInputString("Assignee: ", 20); // enter assignee
            if (!assign.equalsIgnoreCase("nope")) {
                taskInfo.setAssign(assign); // update if assign !=null
            }
            String reviewer = inputReader.getInputString("Reviewer: ", 20); // enter reviewer
            if (!reviewer.equalsIgnoreCase("nope")) {
                taskInfo.setReviewer(reviewer); // update if reviewer !=null
            }
            System.out.println("Update successful");
            if (!inputReader.getInputYesNo("Do you want to continue update? (Y/N): ")) { // if user enters N then will stop update
                return;
            }
        }
    }
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

    private void getDataTasks() {
        System.out.println("========== Task List ==========");
        if (taskList.isEmpty()) {
            // if the taskList is empty then notify
            System.err.println("List is empty.");
            return;
        }
        titleRow(); // Show the title of tasks
        for (int i = taskList.size() - 1; i >= 0; i--) {
            taskList.get(i).displayTask(); // getDataTasks task
        }
    }

    private void addSampleDataTask() {
        taskList.add(new Task(id++, 1, "Dang Viet Anh", LocalDate.of(2021, 4, 11), 10f, 15f, "Nguyen Van An", "Nguyen Hai Linh"));
        taskList.add(new Task(id++, 4, "Tran Xuan Quang", LocalDate.of(2021, 7, 16), 8f, 17.5f, "Tran Hai Nam", "Nguyen Hai Linh"));
        taskList.add(new Task(id++, 3, "Nguyen Quoc Anh", LocalDate.of(2021, 2, 10), 9f, 16f, "Nguyen The Anh", "Nguyen Hai Linh"));
        taskList.add(new Task(id++, 2, "Nguyen Dinh Thang", LocalDate.of(2021, 10, 21), 9f, 17f, "Tran Hong Ngoc", "Nguyen Hai Linh"));
    }

    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        taskManager.displayMainScreen();
    }

    private Task getTaskByID(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private void addTask() {
        System.out.println("========== ADD TASK ==========");
        while (true) {
            String name = inputReader.getInputString("Task Name: ", 20); // enter name
            int taskTypeId = inputReader.getInputNumberInRange("Task Type: (1: Code, 2: Test, 3: Design, 4: Reviewer): ", 0, 4); // enter task type
            LocalDate date = inputReader.getInputDate("Date: "); // enter the date assigned to the task
            float planFrom = Float.parseFloat(inputReader.getInputPlanFrom("From (ex: 8.0 -> 17.5): ", false)); // enter start time
            float planTo;
            while (true) {
                planTo = Float.parseFloat(inputReader.getInputPlanTo("To (ex: 8.0 -> 17.5): ", false)); // enter end time
                if (planTo > planFrom) {
                    // if the end time is greater than the start time then stop
                    break;
                }
                System.out.println("Plan To must be great than Plan From!");
            }
            String assign = inputReader.getInputString("Assignee: ", 20); // enter assignee
            String reviewer = inputReader.getInputString("Reviewer: ", 20); // enter reviewer
            taskList.add(new Task(id, taskTypeId, name, date, planFrom, planTo, assign, reviewer)); // add the assigned task to the taskList
            System.out.println("========== Add task successfully ==========");
            id++; // increase the count of task
            if (!inputReader.getInputYesNo("Do you want to continue add? (Y/N): ")) {
                // if user enters N then will stop adding
                return;
            }
        }
    }

    private void updateDate(Task task) {
        while (true) {
            String inputDate = inputReader.getInputString("Date: ", 11);
            if (inputDate.equalsIgnoreCase("nope")) {
                return;
            } else {
                task.setDate(inputReader.getInputDate("Date: "));
                return;
            }
        }
    }

    private void deleteTask() {
        System.out.println("========== Task Delete ==========");
        if (taskList.isEmpty()) {
            // if the taskList is empty then notify
            System.err.println("List is empty.");
            return;
        }
        int taskID = inputReader.getInputId("Enter ID: ", taskList); // enter id number
        Task task = getTaskByID(taskID);
        titleRow();
        task.displayTask();
        if (!inputReader.getInputYesNo("Do you want to continue delete? (Y/N): ")) { // if user enters N then will stop update
            System.out.println("Delete canceled");
            return;
        }
        taskList.remove(task);
        System.out.println("Delete " + task.getId() + " successfully");
        if (!inputReader.getInputYesNo("Do you want to continue delete? (Y/N): ")) { // if user enters N then will stop update
            System.out.println("Delete canceled");
            return;
        }
    }
}
