
public class CalculatorManager {
    
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
               matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
            System.out.println();
        }
        return matrixResult;
    }
    
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
            System.out.println();
        }
        return matrixResult;
    }
    
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixResult;
    }

    public CalculatorManager() {
    }
    //ma tran 1:   1   3  -2 
              //   4   0   -3
     //ma tran 2:    -2   3   1 
    //               -4   0   3
    //                2   -3  4
    // ma tran 3 = ma tran 1 * ma tran 2
    //(-2-12-4=-18)
    // 9
    //
}
