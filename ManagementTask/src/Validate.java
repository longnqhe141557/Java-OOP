
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Validate {

    Scanner sc = new Scanner(System.in);

    public int getIDtoAdd(ArrayList<Task> list) {
        int lastIndex = list.size() - 1;
        int lastID = list.get(lastIndex).getId();
        int newId = lastID + 1;
        return newId;
    }

    public String getString(String mess) {
        String str;
        while (true) {
            System.out.print(mess);
            str = sc.nextLine();
            if (!str.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Can't empty.");
            }
        }
        return str;
    }

    public String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        Date date;
        while (true) {
            try {
                System.out.print("Date: ");
                date = df.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("invalid date, please input again");
            }
        }
        return df.format(date);
    }

    public int checkInput_Int(String Mess, int MIN, int MAX) {
        int number;
        do {
            System.out.print(Mess);
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number >= MIN && number <= MAX) {
                    break;
                }
                System.err.println("Out of range, Please enter in range:" + MIN + "-" + MAX);
            } catch (Exception e) {
                System.err.println("Invalid input, accept an integer only!!");
            }
        } while (true);
        return number;
    }

    public double checkInput_Double(String Mess, double MIN, double MAX) {
        double number;
        do {
            System.out.print(Mess);
            try {
                number = Double.parseDouble(sc.nextLine());
                if (number >= MIN && number <= MAX) {
                    if (number % 0.5 == 0) {
                        break;
                    } else {
                        System.err.println("Number must divided by 0.5.");
                    }
                } else {
                    System.err.println("Out of range, Please enter in range:" + MIN + " - " + MAX);
                }
            } catch (Exception e) {
                System.err.println("Invalid input, accept an float number only!!");
            }
        } while (true);
        return number;
    }

}
