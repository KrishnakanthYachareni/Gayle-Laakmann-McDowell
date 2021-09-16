package leetcode.learn.arrays;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] in = {{1, 2}, {3, 4}};
        findDiagonalOrder(in);
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] ans = new int[n * m];
        int i = 0, j = 0, idx = 0;
        while (i != n && j != m) {
            while (i >= 0 && j < m) {
                ans[idx] = mat[i][j];
                System.out.println(mat[i][j]);
                i--;
                j++;
                idx++;
            }
            i = 0;
            if (j >= m) {
                break;
            }
            while (i < n && j >= 0) {
                ans[idx] = mat[i][j];
                System.out.println(mat[i][j]);
                i++;
                j--;
                idx++;
            }
            j = 0;
        }
        i = 1;
        j = m - 1;
        while (idx != n * m) {
            while (i < n) {
                ans[idx] = mat[i][j];
                System.out.println(mat[i][j]);
                i++;
                j--;
                idx++;
            }
            i = n - 1;
            j = j + 2;
            while (j < m) {
                ans[idx] = mat[i][j];
                System.out.println(mat[i][j]);
                if (i == n - 1 && j == m - 1) {
                    break;
                }
                i--;
                j++;
                idx++;
            }
            j = m - 1;
        }
        return ans;
    }
}