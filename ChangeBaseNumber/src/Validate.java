
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Validate {

    private final static Scanner sc = new Scanner(System.in);

    public static int getBase() {
        while (true) {
            try {
                int base = Integer.parseInt(sc.nextLine().trim());
                if (base == 2 || base == 10 || base == 16) {
                    return base;
                } else {
                    System.err.println("Only base 2,10,16");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Only base 2,10,16");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String getInput(int type) { 
        String num = "";
        String value = "";
        while (true) {
            System.out.print("Enter number: ");
            num = sc.nextLine();//người dùng nhập số
            switch (type) {
                case 2:
                    value = "^[0-1]{1,}$";//người dùng chỉ được phép nhập chuỗi có kí tự là 0 với 1
                    break;
                case 10:
                    value = "^[0-9]{1,}$";//^[0123456789]*$
                    break;
                case 16:
                    value = "^[0-9a-fA-F]{1,}$";//^[0123456789abcdefABCDEF]*$
                    break;
            }
            if (num.matches(value)) {
                return num;
            } else {
                System.out.println("Please enter again!!");
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.err.println("You must choose Y(y) or N(n), not other character!!!: ");
        }
    }

}
