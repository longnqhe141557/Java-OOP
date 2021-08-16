
import java.util.ArrayList;
public class TaskManager {

    public void menu() {
        System.out.println("========= Task program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete task");
        System.out.println("3. Display task");
        System.out.println("4. Exit");
    }

    public void getDataTasks(ArrayList<Task> list) {
        System.out.println("-------------------------Task-------------------------");
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : list) {
            System.out.println(task);
        }
    }

    public void addTask(ArrayList<Task> list) {
        Validate v = new Validate();
        System.out.println("---------------Add Task---------------");
        int ID = v.getIDtoAdd(list);
        String name = v.getString("Requirement Name: ");
        int typeID = v.checkInput_Int("Task Type: ", 1, 4);
        String date = v.getDate();
        double from = v.checkInput_Double("From: ", 8.0, 17.0);
        double to = v.checkInput_Double("To: ", from+0.5, 17.5);
        String assignee = v.getString("Assignee: ");
        String reviewer = v.getString("Reviewer: ");
        Task t = new Task(ID, name, typeID, date, from, to, assignee, reviewer);
        list.add(t);
        System.err.println("Add Task successfully.");
    }

    public void deleteTask(ArrayList<Task> list) {
        Validate v = new Validate();
        boolean check = true;
        int ID = v.checkInput_Int("ID: ", 1, Integer.MAX_VALUE);
        for (int i = 0; i < list.size(); i++) {
            if (ID == list.get(i).getId()) {
                list.remove(i);
                check = false;
                System.err.println("Delete a task successfully.");
                break;
            }
        }
        if (check) {
            System.err.println("Delete a task fail.");
        }
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Validate v = new Validate();       
        ArrayList<Task> list = new ArrayList<>();
        list.add(new Task(1, "Dev Program", 1, "28-08-2021", 8.0, 15.5, "Dev", "Lead"));
        list.add(new Task(2, "Dev Program", 2, "22-05-2021", 9.5, 17.5, "Dev", "Lead"));
        list.add(new Task(3, "Dev Program", 3, "18-02-2021", 9.0, 16.0, "Dev", "Lead"));
        tm.menu();
        while (true) {         
            int choice = v.checkInput_Int("Enter choice: ", 1, 4);
            switch (choice) {
                case 1:
                    tm.addTask(list);
                    break;
                case 2:
                    tm.deleteTask(list);
                    break;
                case 3:
                    tm.getDataTasks(list);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
