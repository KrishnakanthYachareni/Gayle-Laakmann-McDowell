package hackerrank;

public final class HourGlass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {

            }
        }
        return 1;
    }

    public static void main(String[] args) {

        int arr[][] = {{1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};
        System.out.println(hourglassSum(arr));

    }
}