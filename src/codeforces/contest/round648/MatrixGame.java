/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package codeforces.contest.round648;

import java.io.*;

/**
 * Find out the no of empty rows and empty columns in a matrix. Then min(empty rows, empty columns) % 2 == 0 "Vivek"
 * else "Ashish".
 * <p>
 * Remember they both are playing optimally.
 *
 * @link https://codeforces.com/contest/1365/problem/A
 */
public final class MatrixGame {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] sizes = reader.readLine().split(" ");
            int n = Integer.parseInt(sizes[0]);
            int m = Integer.parseInt(sizes[1]);
            int rowCount = n;
            if (n <= 50 && m <= 50) {
                char[][] mat = new char[n][m];
                for (int i = 0; i < n; i++) {
                    String row = reader.readLine().replace(" ", "");
                    if (row.contains("1")) {
                        rowCount--;
                    }
                    mat[i] = row.toCharArray();
                }
                int colCount = colCount(mat, n, m);
                int min = Math.min(colCount, rowCount);
                if (min % 2 == 0) {
                    writer.write("Vivek\n");
                } else {
                    writer.write("Ashish\n");
                }
                writer.flush();
            }
        }
    }

    private static int colCount(char[][] mat, int n, int m) {
        int count = m;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[j][i] == '1') {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
