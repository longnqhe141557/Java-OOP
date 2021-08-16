
public class Main {

    Validate v = new Validate();
    CalculatorManager CalcManager = new CalculatorManager();
    CalculatorView CalcView = new CalculatorView();

    public void addMatrix(int[][] matrix1, int[][] matrix2, int[][] matrixResult) {
        matrixResult = CalcManager.additionMatrix(matrix1, matrix2);
        System.out.println("-----Result-----");
        CalcView.showMatrix(matrix1);
        System.out.println("+");
        CalcView.showMatrix(matrix2);
        System.out.println("=");
        CalcView.showMatrix(matrixResult);
    }

    public void subMatrix(int[][] matrix1, int[][] matrix2, int[][] matrixResult) {
        matrixResult = CalcManager.subtractionMatrix(matrix1, matrix2);
        System.out.println("-----Result-----");
        CalcView.showMatrix(matrix1);
        System.out.println("-");
        CalcView.showMatrix(matrix2);
        System.out.println("=");
        CalcView.showMatrix(matrixResult);
    }

    public void multipleMatrix(int[][] matrix1, int[][] matrix2, int[][] matrixResult) {
        matrixResult = CalcManager.multiplicationMatrix(matrix1, matrix2);
        System.out.println("-----Result-----");
        CalcView.showMatrix(matrix1);
        System.out.println("*");
        CalcView.showMatrix(matrix2);
        System.out.println("=");
        CalcView.showMatrix(matrixResult);
    }

    public int displayMenu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        int choice = v.checkInput_Int("Your choice: ", 1, 4);
        return choice;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Validate v = new Validate();
        CalculatorManager CalcManager = new CalculatorManager();
        CalculatorView CalcView = new CalculatorView();
        while (true) {
            int choice = m.displayMenu();
            int[][] matrix1 = CalcView.inputMatrix1();
            int row1 = matrix1.length;
            int col1 = matrix1[0].length;
            int[][] matrixResult = null;
            switch (choice) {
                case 1: {
                    int[][] matrix2 = CalcView.inputMatrix2(1, row1, col1);
                    m.addMatrix(matrix1, matrix2, matrixResult);
                    break;
                }
                case 2: {
                    int[][] matrix2 = CalcView.inputMatrix2(2, row1, col1);
                    m.subMatrix(matrix1, matrix2, matrixResult);
                    break;
                }

                case 3: {
                    int[][] matrix2 = CalcView.inputMatrix2(3, row1, col1);
                    m.multipleMatrix(matrix1, matrix2, matrixResult);
                    break;
                }
                case 4: {
                    System.exit(0);     
                }

            }

        }
    }

}
