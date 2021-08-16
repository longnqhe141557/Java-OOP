
import java.util.ArrayList;

public class ManageDoctor {

    Validate v = new Validate();

    public void menu() {
        System.out.println("1. Display doctor");
        System.out.println("2. Add doctor");
        System.out.println("3. Update doctor");
        System.out.println("4. Delete doctor");
        System.out.println("5. Search doctor");
        System.out.println("6. Exit");
    }

    public void displayAllDoctor(ArrayList<Doctor> list) {
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor doctor : list) {
            System.out.println(doctor);
        }
    }

    public void addDoctor(ArrayList<Doctor> list) {
        String code = v.getString("Enter code: ", "[a-zA-Z0-9 ]+");
        Doctor d = v.checkDoctorExist(list, code);
        if (d != null) {
            System.err.println("Doctor already exist.");
            return;
        }
        String name = v.getString("Enter name: ", "[a-zA-Z]+");
        String specialization = v.getString("Enter specialization: ", "[a-zA-Z]+");
        int availability = v.checkInput_Int("Enter availability: ", 1, Integer.MAX_VALUE);
        d = new Doctor(code, name, specialization, availability);
        list.add(d);
        System.err.println("Add successful.");
    }

    public void updateDoctor(ArrayList<Doctor> list) {
        String code = v.getString("Enter code: ", "[a-zA-Z0-9 ]+");
        Doctor d = v.checkDoctorExist(list, code);
        if (d == null) {
            System.err.println("Doctor isn't exist.");
            return;
        }
        String name = v.getString("Enter name: ", "[a-zA-Z]*");
        String specialization = v.getString("Enter specialization: ", "[a-zA-Z]*");
        String availability = v.getString("Enter availability: ", "[0-9]*");
        if (!name.isEmpty()) {
            d.setName(name);
        }
        if (!specialization.isEmpty()) {
            d.setSpecialization(specialization);
        }
        if (!availability.isEmpty()) {
            d.setAvailability(Integer.parseInt(availability));
        }
        System.err.println("Update successful");
    }

    public void deleteDoctor(ArrayList<Doctor> list) {
        System.out.println("--------- Delete Doctor ---------");
        String code = v.getString("Enter code: ", "[a-zA-Z0-9 ]+");
        Doctor d = v.checkDoctorExist(list, code);
        if (d == null) {
            System.err.println("Doctor isn't exist.");
            return;
        }
        list.remove(d);
        System.err.println("Remove successfully.");
    }

    public void searchDoctor(ArrayList<Doctor> list) {
        System.out.println("------- Search Doctor -------");
        String str = v.getString("Enter string: ", "[a-zA-Z0-9 ]+");
        ArrayList<Doctor> listFoundByInputString = new ArrayList<>();
        for (Doctor doctor : list) {
            if (doctor.toString().contains(str)) {
                listFoundByInputString.add(doctor);
            }
        }
        if (listFoundByInputString.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByInputString) {
                System.out.println(doctor);
            }
        }
    }

    public static void main(String[] args) {
        ManageDoctor md = new ManageDoctor();
        Validate v = new Validate();
        md.menu();
        ArrayList<Doctor> list = new ArrayList<Doctor>();
        list.add(new Doctor("DOC 1", "Nghia", "Orthopedics", 3));
        list.add(new Doctor("DOC 2", "Phuong", "Obstetrics", 2));
        list.add(new Doctor("DOC 3", "Lien", "Orthodontic", 1));
        while (true) {
            int choice = v.checkInput_Int("Enter your choice: ", 1, 6);
            switch (choice) {
                case 1:
                    md.displayAllDoctor(list);
                    break;
                case 2:
                    md.addDoctor(list);
                    break;
                case 3:
                    md.updateDoctor(list);
                    break;
                case 4:
                    md.deleteDoctor(list);
                    break;
                case 5:
                    md.searchDoctor(list);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
