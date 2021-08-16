
package tienphongbank;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {   
    public static void menu(){
        System.out.println("----------Login Program----------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");       
    }   
    public static int checkInput_Int(String Mess, int MIN, int MAX){
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
    
    public static void main(String[] args) {      
        TpBank tp = new TpBank();       
        while (true) {            
            menu();
            int choice = checkInput_Int("Enter your choice: ", 1, 3);
            String capcha ="";
            ResourceBundle bundle;
            switch(choice){
                case 1:                    
                    Locale localeVi = new Locale("vi", "VN");
                    bundle = ResourceBundle.getBundle("tienphongbank.Languages", localeVi);                    
                    tp.checkAccount(bundle);
                    tp.checkPassword(bundle);
                    capcha = tp.randomCapchar();
                    tp.checkCapchar(capcha,bundle);
                    break;
                case 2:
                    Locale localeEn = new Locale("en", "US");
                    bundle = ResourceBundle.getBundle("tienphongbank.Languages", localeEn);
                    tp.checkAccount(bundle);
                    tp.checkPassword(bundle);
                    capcha = tp.randomCapchar();
                    tp.checkCapchar(capcha,bundle);
                    break;
                case 3:
                    System.exit(0);
            }
        }
        
    }
    
}
