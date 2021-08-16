/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        while(true){
        System.out.println("================Convert Table ================");
        System.out.print("Choose base input: ");
        int inputBase = Validate.getBase();
        String inputNumber = Validate.getInput(inputBase);
        
        System.out.print("Choose base output: ");
        int outputBase = Validate.getBase();
        String ans = ""; 
             
        if(inputBase == 10){
            ans = Manager.convertDecToOtherBase(inputNumber, outputBase);
        }else{
            int decimal = Manager.convertToDecimal(inputNumber, inputBase);
            ans = Manager.convertDecToOtherBase(decimal+"", outputBase);
        }
        System.out.println(inputNumber + "(" + inputBase + ") = " + ans + "(" + outputBase + ")");
        System.out.println("===============================================");
        System.out.println("Do you want to continue ? (Y/N)");
        boolean yn = Validate.checkInputYN();
        if(yn == false)
            return;
        }
    }

}
