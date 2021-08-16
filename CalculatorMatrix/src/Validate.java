
import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);
    public int checkInput_Int(String Mess, int MIN, int MAX){
        Scanner sc = new Scanner(System.in);
        int Number;
        do {            
            System.out.print(Mess);
            try {
                Number = Integer.parseInt(sc.nextLine());
                if(Number >= MIN && Number <= MAX){
                    break;
                }
                System.out.println("Out of range, Please enter in range:"+MIN+"-"+MAX);
            } catch (Exception e) {
                System.out.println("Invalid input, accept an integer only!!");
            }
        } while (true);
        return Number;
    }
}
