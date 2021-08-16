
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageEmployee {

    Validate v = new Validate();

    public void menu() {
        System.out.println("1. Display all employees");
        System.out.println("2. Add employees ");
        System.out.println("3. Update employees ");
        System.out.println("4. Remove employees ");
        System.out.println("5. Search employees ");
        System.out.println("6. Sort employees by salary ");
        System.out.println("7. Exit ");
    }

    public void displayAllEm(ArrayList<Employee> list) {
        System.out.printf("%-10s%-10s%-10s%-20s%-20s%-15s%-15s%-10s%-9s%-10s\n", "ID",
                "FirstName", "LastName", "Phone Number", "Email",
                "Address", "DOB", "Sex", "Salary", "Egency");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    public void addEmployee(ArrayList<Employee> list) {
        String ID = v.getString("Enter ID: ", "[a-zA-Z0-9]+");
        Employee e = v.checkEmployeeIsExist(list, ID);
        if (e != null) {
            System.err.println("Employee already exist!");
            return;
        }
        String fName = v.getString("Enter first name: ", "[a-zA-Z]+");
        String lName = v.getString("Enter last name: ", "[a-zA-Z]+");
        String phone = v.getString("Enter phone number: ", "[0-9]+");
        String email = v.getString("Enter email: ", "[a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,}");// longnqhe14@fpt.edu.vn
        String address = v.getString("Enter address: ", "[a-zA-Z0-9 ]+");
        String dob = v.getDate();
        String sex = v.getString("Enter sex: ", "[a-zA-Z]+");
        double salary = v.checkInput_Double("Enter salary: ", 1.0, Double.MAX_VALUE);
        String egency = v.getString("Enter egency: ", "[a-zA-Z]+");
        e = new Employee(ID, fName, lName, phone, email, address, dob, sex, salary, egency);
        list.add(e);
        System.err.println("Add successful.");
    }

    public void updateEmployee(ArrayList<Employee> list) {
        String ID = v.getString("Enter ID: ", "[a-zA-Z0-9]+");
        Employee e = v.checkEmployeeIsExist(list, ID);
        if (e == null) {
            System.err.println("Employee does not exist.");
            return;
        }
        e.setfName(v.getString("Enter first name: ", "[a-zA-Z]+"));
        e.setlName(v.getString("Enter last name: ", "[a-zA-Z]+"));
        e.setPhoneNumber(v.getString("Enter phone number: ", "[0-9]+"));
        e.setEmail(v.getString("Enter email: ", "[a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,}"));
        e.setAddress(v.getString("Enter address: ", "[a-zA-Z0-9 ]+"));
        e.setDob(v.getDate());
        e.setSex(v.getString("Enter sex: ", "[a-zA-Z]+"));
        e.setSalary(v.checkInput_Double("Enter salary: ", 1.0, Double.MAX_VALUE));
        e.setEgency(v.getString("Enter egency: ", "[a-zA-Z]+"));
        System.err.println("Update successful");
    }

    public void deleteEmployee(ArrayList<Employee> list) {
        System.out.println("--------- Delete Employee ---------");
        String ID = v.getString("Enter ID: ", "[a-zA-Z0-9]+");
        Employee e = v.checkEmployeeIsExist(list, ID);
        if (e == null) {
            System.err.println("Employee does not exist.");
            return;
        }
        list.remove(e);
        System.err.println("Remove successfully.");
    }

    public void searchEmployee(ArrayList<Employee> list) {
        System.out.println("------- Search Employee-------");
        String name = v.getString("Enter name: ", "[a-zA-Z ]+");
        int count = 0;
        for (Employee e : list) {
            String fullname = e.getfName() + " " + e.getlName();
            if (fullname.toLowerCase().contains(name.toLowerCase())) {
                System.out.println(e);
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Can find.");
        }
    }

    public void sortEmployee(ArrayList<Employee> list) {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary()); // tăng dần
            }
        });
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ManageEmployee me = new ManageEmployee();
        Validate v = new Validate();
        me.menu();
        ArrayList<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee("E1", "Nguyen", "Long", "0914385193", "long14@fpt.edu.vn", "Ha Noi", "14-03-2000", "Male", 1000, "Lead");
        Employee e2 = new Employee("E2", "Tran", "Duy", "0921456193", "long14@fpt.edu.vn", "Ha Noi", "14-03-2000", "Male", 1100, "Lead");
        Employee e3 = new Employee("E3", "Phuong", "Hai", "0998654213", "long14@fpt.edu.vn", "Ha Noi", "14-03-2000", "Male", 900, "Lead");
        list.add(e1);
        list.add(e2);
        list.add(e3);
        while (true) {
            int choice = v.checkInput_Int("Enter choice: ", 1, 7);
            switch (choice) {
                case 1:
                    me.displayAllEm(list);
                    break;
                case 2:
                    me.addEmployee(list);
                    break;
                case 3:
                    me.updateEmployee(list);
                    break;
                case 4:
                    me.deleteEmployee(list);
                    break;
                case 5:
                    me.searchEmployee(list);
                    break;
                case 6:
                    me.sortEmployee(list);
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
}
