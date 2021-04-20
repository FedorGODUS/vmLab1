import lombok.NoArgsConstructor;


@NoArgsConstructor
public class MathModule {

    public int performOperation(float[][] matrix, int n) {
        int i, j, k, c, flag = 0;

        for (i = 0; i < n; i++) {
            if (matrix[i][i] == 0) {
                c = 1;
                while ((i + c) < n && matrix[i + c][i] == 0)
                    c++;
                if ((i + c) == n) {
                    flag = 1;
                    break;
                }
                for (j = i, k = 0; k <= n; k++) {
                    float temp = matrix[j][k];
                    matrix[j][k] = matrix[j + c][k];
                    matrix[j + c][k] = temp;
                }
            }

            for (j = 0; j < n; j++) {
                if (i != j) {
                    float p = matrix[j][i] / matrix[i][i];

                    for (k = 0; k <= n; k++)
                        matrix[j][k] = matrix[j][k] - (matrix[i][k]) * p;
                }
            }
        }
        return flag;
    }


    //    проверка ответа
    public int checkConsistency(float[][] a, int n) {
        int i, j;
        float sum;

        // flag == 2 бесконечно
        // flag == 3 нет решений
        int flag = 3;
        for (i = 0; i < n; i++) {
            sum = 0;
            for (j = 0; j < n; j++)
                sum = sum + a[i][j];
            if (sum == a[i][j])
                flag = 2;
        }
        return flag;
    }


    public double determinant(float[][] matrix, int len) {
        double det;
        if (len == 1) {
            det = matrix[0][0];
        } else if (len == 2) {
            det = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        } else {
            det = 0;
            for (int j1 = 0; j1 < len; j1++) {
                float[][] m = new float[len - 1][];
                for (int k = 0; k < (len - 1); k++) {
                    m[k] = new float[len - 1];
                }
                for (int i = 1; i < len; i++) {
                    int j2 = 0;
                    for (int j = 0; j < len; j++) {
                        if (j == j1)
                            continue;
                        m[i - 1][j2] = matrix[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0, 1.0 + j1 + 1.0) * matrix[0][j1] * determinant(m, len - 1);
            }
        }
        return det;
    }


    public float[] getNeut(float[][] matrix, int n, float[][] oldMatrix) {
        float[] answers = new float[n];
        float[] ans = new float[n];
        float part = 0;
        for (int i = 0; i < n; i++) {
            answers[i] = matrix[i][n] / matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                part += (answers[j] * oldMatrix[i][j]);
            }
            ans[i] = part;
            part = 0;
        }
        return ans;
    }


}
