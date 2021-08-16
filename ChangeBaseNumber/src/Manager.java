

/**
 *
 * @author User
 */
public class Manager {

    public static final String hexValue = "0123456789ABCDEF";

    public static int convertToDecimal(String inputNumber, int inputBase) {
        inputNumber = inputNumber.toUpperCase();
        int answer = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            int value = hexValue.indexOf(inputNumber.charAt(i));
            int after = (int) Math.pow(inputBase, inputNumber.length() - 1 - i);
            answer += value * after;
        }
        return answer;
    }
    //Ví dụ người dùng nhập vào: inputBase = 16, inputNumber = 4F or 4f
    //ở vòng lặp đầu tiên( i = 0):
    //value = 4
    //after = Math.pow(16, 1) = 16
    //answer = 16*4 = 64
    //i = 1:
    //value = 15
    //after = Math.pow(16, 0) = 1
    //value*after = 15
    //suy ra answer = 64+15 = 79 ở hệ cơ số 10
    

    public static String convertDecToOtherBase(String inputNumber, int outputBase) {
        String answer = "";
        int number = Integer.parseInt(inputNumber);
        while (number > 0) {
            int mod = number % outputBase; // thực hiện chia để lấy phần dư        
            answer += hexValue.charAt(mod); //lấy được số dư thì ta lấy kí tự của chuỗi ở vị trí chỉ định đã truyền vào
            number /=  outputBase;// thực hiện chia lấy nguyên
            //vòng lặp kết thúc khi number = 0.
        }        
        String ans = "";
        for (int i = answer.length()-1; i >=0 ; i--) {
            ans += answer.charAt(i);
        }
          return ans;
    }
    //123456 length = 6 
    // i = 6,5,4,3,2,1
    //Ví dụ người dùng nhập: inputNumber = 79(inputBase = 10) và outputBase = 16
    // vòng đầu tiên
    // mod = 79%16 = 15
    // answer = F
    // number = 4
    // vòng thứ 2:
    // mod = 4%16 = 4
    // answer = F4
    // number = 0
    // dùng for duyệt ngược lại đc kết quả cuối cùng là 4F

}
