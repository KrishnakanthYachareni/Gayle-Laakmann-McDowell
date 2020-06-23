/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package hackerrank.contest.smartinterview16b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PatternRepresentation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String str = reader.readLine();
            String ans = pattern(str);
            writer.write(ans);
            writer.newLine();
        }
        writer.flush();
    }

    public static String pattern(String pattern) {
        char result[] = new char[pattern.length() + 1];
        int c = 1;
        for (int i = 0; i <= pattern.length(); i++) {
            if (pattern.length() == i || 'S' == pattern.charAt(i)) {
                for (int j = i - 1; j >= -1; j--) {
                    result[j + 1] = (char) ((int) '0' + c++);
                    if (j >= 0 && 'S' == pattern.charAt(j))
                        break;
                }
            }
        }
        return new String(result);
    }
}
