
package tienphongbank;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TpBank {
    
    public void checkAccount(ResourceBundle bundle){
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.print(bundle.getString("account"));
            String account = sc.nextLine();           
            Pattern p = Pattern.compile("^[0-9]{10}$");
            if(p.matcher(account).matches()){
                break;
            }else{
                 System.out.println(bundle.getString("check.account"));     
            }
        }  
    }
    
    public void checkPassword(ResourceBundle bundle){
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.print(bundle.getString("password"));
            String password = sc.nextLine();
            Pattern p1 = Pattern.compile("^[0-9A-Za-z]{8,31}$"); 
            Pattern p2 = Pattern.compile("^[A-Za-z0-9]*[0-9]+[A-Za-z0-9]*$"); 
            Pattern p3 = Pattern.compile("^[A-Za-z0-9]*[A-Za-z]+[A-Za-z0-9]*$");
                    
            if(p1.matcher(password).matches() && p2.matcher(password).matches() &&p3.matcher(password).matches()){
                break;
            }else{
                 System.out.println(bundle.getString("wrong.password"));              
            }
        }    
    }
    
    public String randomCapchar() {
        String root = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";      
        String capcha ="";
        int length = root.length();// = 62
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(length);//tra ve index bat ki nam trong khoang 0 - 61
            capcha = capcha + root.charAt(index);
        }
        System.out.print("Capchar: "+capcha);
        System.out.println("");
        return capcha;       
    }
    
    public void checkCapchar(String capcha,ResourceBundle bundle){
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (true) {            
            System.out.print(bundle.getString("capcha"));
            input = sc.nextLine();
            if(capcha.contains(input)){
                System.out.println(bundle.getString("right.capcha"));
                break;
            }else{
                System.out.println(bundle.getString("wrong.capcha"));      
            }
        }       
    }
    public static void main(String[] args) {
        TpBank tp = new TpBank();
        String oID = tp.randomCapchar();
        
    }
    
}
