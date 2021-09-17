package codesignal.interview.practice;

/**
 * https://app.codesignal.com/interview-practice/task/5A8jwLGcEpTPyyjTB/description
 * <p>
 * Asked in Google, Amazon and many.
 * <p>
 * Very Important question.
 */
public class RotateImage {
    public static void main(String[] args) {

    }

    int[][] rotateImage(int[][] a) {
        int n = a.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = a[n - 1 - j][i];
                a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
                a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
                a[j][n - 1 - i] = a[i][j];
                a[i][j] = temp;
            }
        }
        return a;
    }
}
