
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class BubbleSort {

    public static int checkInput() {
        int n = 0;
        System.out.print(" ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.out.println("Invalid input, accept an integer only!");
                } else {
                    break;
                }
            } catch (Exception e) {
                    System.out.println("Invalid input, accept an integer only!");
            }

        }
        return n;
    }
    
    public static int inputSizeofArray(){
        System.out.print("Enter number of array: ");
        int size = checkInput();
        return size;
    }
    public static int [] inputValueOfArray(int n){
        int[] a = new int[n];
        for(int i = 0; i<n;i++){
            System.out.print("Enter a["+i+"]: ");
            a[i] = checkInput();
        }
        return a;
    }
    
    
    
    public static void main(String[] args) {
        System.out.print("Enter number of array: ");
        int size = checkInput();
        int[] a = new int[size];
        
        for(int i = 0; i<size;i++){
            System.out.print("Enter a["+i+"]: ");
            a[i] = checkInput();
        }
        
        System.out.println("Unsorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        
        
        for(int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println("");
        System.out.println("Sorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+ " ");
        }
    }

}
