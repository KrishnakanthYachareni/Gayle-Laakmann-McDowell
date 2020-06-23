/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package spoj.classical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @link https://www.spoj.com/problems/VECTAR11/
 */
public class Vector11 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ans = gameArray((int) 1e6);
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            if (ans[n] == 1) {
                writer.write("Win");
            } else {
                writer.write("Lose");
            }
            writer.newLine();
            writer.flush();
        }
    }

    public static int[] gameArray(int size) {
        int[] preArr = new int[size + 1];
        for (int i = 1; i < size; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (preArr[i - j * j] == 0) {
                    preArr[i] = 1;
                    break;
                }
            }
        }
        return preArr;
    }
}
