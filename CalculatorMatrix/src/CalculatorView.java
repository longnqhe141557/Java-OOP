
public class CalculatorView {

    Validate v = new Validate();

    public int[][] inputMatrix1() {
        int row1 = v.checkInput_Int("Enter Row Matrix 1: ", 1, Integer.MAX_VALUE);
        int col1 = v.checkInput_Int("Enter column Matrix 1: ", 1, Integer.MAX_VALUE);
        int[][] matrix1 = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix1[i][j] = v.checkInput_Int("Enter Matrix1[" + (i + 1) + "][" + (j + 1) + "]: ", 1, Integer.MAX_VALUE);
            }
        }
        return matrix1;
    }

    public int[][] inputMatrix2(int choice, int row1, int col1) {
        int row2, col2;
        while (true) {
            row2 = v.checkInput_Int("Enter row matrix2: ", 1, Integer.MAX_VALUE);
            if (choice == 1 || choice == 2) {
                if (row2 != row1) {
                    System.err.println("The number of rows of Matrix 2 must be equal to the number of rows of Matrix1.");
                } else {
                    break;
                }
            }if (choice == 3) {
                if (row2 != col1) {
                    System.err.println("The number of rows of Matrix 2 must be equal to the number of columns of Matrix1.");
                } else {
                    break;
                }
            } 
        }
        while (true) {
            col2 = v.checkInput_Int("Enter column Matrix2: ", 1, Integer.MAX_VALUE);
            if (choice == 1 || choice == 2) {
                if (col2 != col1) {
                    System.err.println("The number of columns of Matrix 2 must be equal to the number of columns of Matrix1.");
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        int[][] matrix2 = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                matrix2[i][j] = v.checkInput_Int("Enter Matrix2[" + (i + 1) + "][" + (j + 1) + "]: ", 0, Integer.MAX_VALUE);
            }
        }
        return matrix2;
    }
    public void showMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
   
}
