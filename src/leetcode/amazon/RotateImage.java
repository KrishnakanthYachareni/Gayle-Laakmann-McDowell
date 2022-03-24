package leetcode.amazon;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {

    /**
     * he most elegant solution for rotating the matrix is to firstly reverse the matrix around the main diagonal,
     * and then reverse it from left to right. These operations are called transpose and reflect in linear algebra.
     */
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    // Since it's the N * N matrix, in place transpose of matrix is exist.
    private static void transpose(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    // Reverse the row numbers from left to right
    private static void reflect(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) { // half of the column
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - j - 1];
                mat[i][n - j - 1] = temp;
            }
        }
    }

}
