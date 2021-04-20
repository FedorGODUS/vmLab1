import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@NoArgsConstructor
@Data
public class InputModule {
    private Scanner scanner = new Scanner(System.in);
    private FileReader fileReader;
    private String path = "C:\\Users\\fedor\\Desktop\\VM itmo2\\vmLab1\\src\\main\\java\\test";

    public float[][] inputInConsole() {
        int len = scanner.nextInt();
        while (len > 20 || len < 1) {
            len = scanner.nextInt();
        }
        float[][] matrix = new float[len][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len + 1; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public float[][] inputInFile() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(path));
        int size = Integer.parseInt(file.readLine().trim());
        if (size > 20 || size < 1) {
            return null;
        }
        float[][] matrix = new float[size][size + 1];
        for (int i = 0; i < size; i++) {
            String[] row = file.readLine().trim().split(" ");
            if (row.length > size + 1)
                throw new ArrayIndexOutOfBoundsException();
            for (int j = 0; j < size + 1; j++) {
                matrix[i][j] = Float.parseFloat(row[j].trim());
            }
        }

        return matrix;
    }

    public void PrintMatrix(float[][] matrix) {
        for (float[] floats : matrix) {
            for (int j = 0; j <= matrix.length; j++)
                System.out.print(floats[j] + " ");
            System.out.println();
        }
    }

    public void PrintResult(float[][] a, int n, int flag) {
        System.out.print("Ответы: ");

        if (flag == 2)
            System.out.println("ответа нет (получается бесконечность)");
        else if (flag == 3)
            System.out.println("ответа нет (его не существует)");
        else {
            for (int i = 0; i < n; i++) {
                System.out.print("x" + (i + 1) + " = " + a[i][n] / a[i][i] + "      ");
            }
        }
    }


}
