
import java.util.ArrayList;
import java.util.Scanner;

public class Validate {

    Scanner sc = new Scanner(System.in);

    //Hàm get số nguyên của thầy
    public int checkInput_Int(String Mess, int MIN, int MAX) {
        int Number;
        do {
            System.out.print(Mess);
            try {
                Number = Integer.parseInt(sc.nextLine());
                if (Number >= MIN && Number <= MAX) {
                    break;
                }
                System.out.println("Out of range, Please enter in range:" + MIN + "-" + MAX);
            } catch (Exception e) {
                System.out.println("Invalid input, accept an integer only!!");
            }
        } while (true);
        return Number;
    }

    public String getString(String mess, String regex) {
        String result = "";
        while (true) {
            System.out.print(mess);
            result = sc.nextLine().trim();
            if (result.matches(regex)) {
                break;
            } else {
                System.err.println("Invalid! Please input again!");
            }
        }
        return result;
    }

    public Doctor checkDoctorExist(ArrayList<Doctor> list, String code) {
        for (Doctor doctor : list) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }
}
