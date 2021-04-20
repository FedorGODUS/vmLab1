import java.io.IOException;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        MathModule module = new MathModule();
        float[][] matrix;
        float[][] oldMatrix;
        InputModule inputModule = new InputModule();
        System.out.print("Ввод ");
        if ("файл".equals(scanner.next())) {
            matrix = inputModule.inputInFile();
        } else {
            matrix = inputModule.inputInConsole();
        }
        inputModule.PrintMatrix(matrix);
        oldMatrix = matrix;

        System.out.println();
        int flag = module.performOperation(matrix, matrix.length);
        if (flag == 1) {
            flag = module.checkConsistency(matrix, matrix.length);
        }
        inputModule.PrintResult(matrix, matrix.length, flag);
        System.out.println();
        System.out.println();
        inputModule.PrintMatrix(matrix);

        System.out.println();
        System.out.println("это определитель: "+module.determinant(oldMatrix, oldMatrix.length));
        System.out.println();
        System.out.print("это вектор неувязок: ");
        for (float an: module.getNeut(matrix, matrix.length, oldMatrix)){
            System.out.print(an+" ");
        }


    }
}
