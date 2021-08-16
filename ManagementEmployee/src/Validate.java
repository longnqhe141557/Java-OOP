
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Validate {
    
    Scanner sc = new Scanner(System.in);
    
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
    
    public double checkInput_Double(String Mess, double MIN, double MAX) {
        double Number;
        do {
            System.out.print(Mess);
            try {
                Number = Double.parseDouble(sc.nextLine());
                if (Number >= MIN && Number <= MAX) {
                    break;
                }
                System.out.println("Out of range, Please enter in range:" + MIN + "-" + MAX);
            } catch (Exception e) {
                System.out.println("Invalid input!");
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
    
    public Employee checkEmployeeIsExist(ArrayList<Employee> list, String ID) {
        for (Employee e : list) {
            if (ID.equalsIgnoreCase(e.getID())) {
                return e;
            }
        }
        return null;
    }

    public String getDate() {
        Date date;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        while (true) {
            try {
                System.out.print("Input date: ");
                date = df.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Invalid! please input again! ");
            }
        }
        return df.format(date);
    }
    public static void main(String[] args) {
        Validate v = new Validate();
        String email = v.getString("Email: ", "[a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,}");
        System.out.println(email);
    } 
}
