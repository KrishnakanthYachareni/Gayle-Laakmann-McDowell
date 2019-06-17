package hackerrank;

import java.util.Scanner;

class Knapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests = sc.nextInt();
        for (int i = 0; i <= numberOfTests; i++) {
            int capacity = sc.nextInt();
            int noOfItems = sc.nextInt();
            int[] weights = readItems(sc, noOfItems);
            int[] values = readItems(sc, noOfItems);
            System.out.println(computeMaxValue(values, weights, capacity));
        }
    }

    public static int computeMaxValue(int[] values, int[] weights, int capacity) {
        int n = weights.length;
        int[][] tempVal = new int[n + 1][capacity + 1];
        for (int col = 0; col <= capacity; col++) {
            tempVal[0][col] = 0;
        }
        for (int row = 0; row <= n; row++) {
            tempVal[row][0] = 0;
        }
        for (int item = 1; item <= n; item++) {
            for (int weight = 1; weight <= capacity; weight++) {
                if (weights[item - 1] <= weight) {
                    tempVal[item][weight] =
                            Math.max(values[item - 1] + tempVal[item - 1][weight - weights[item - 1]],
                                    tempVal[item - 1][weight]);
                } else {
                    tempVal[item][weight] = tempVal[item - 1][weight];
                }
            }
        }
        return tempVal[n][capacity];
    }

    private static int[] readItems(Scanner sc, int noOfItems) {
        int[] ar = new int[noOfItems];
        for (int j = 0; j < noOfItems; j++) {
            ar[j] = sc.nextInt();
        }
        return ar;
    }
}