package leetcode.learn.arrays;

import java.util.Scanner;

public class MinDupSubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases;
        test_cases = sc.nextInt();

        while (test_cases > 0) {
            int n;
            n = sc.nextInt();
            String str = sc.next();
            int[] hash = new int[26];
            for (int i = 0; i < 26; i++) {
                hash[i] = 0;
            }
            int ans = 0;
            // Iterating through each character of string
            for (int i = 0; i < n; i++) {
                // Finding 0 based indexing of character at ith position of string
                int index = str.charAt(i) - 'a';
                // If we have encounterd current string before as well then it means 1 more substring has to be
                // made
                if (hash[index] >= 1) {
                    ans++;
                    // Assigning each hash element to 0 again for new substring
                    for (int j = 0; j < 26; j++) {
                        hash[j] = 0;
                    }
                    // Taking ith character as a part of new substring so we have to store it's frequency i.e 1
                    hash[index] = 1;
                }
                // If we haven't encountered ith currect in our current substring then we have simply add it in our
                // current substirng
                else hash[index] = 1;
            }
            // Finally checking corner case that last substring isn't counted
            // Eg if we have substring ab then answer would be 1, for this the next loop is required
            for (int i = 0; i < 26; i++) {
                if (hash[i] >= 1) {
                    ans++;
                    break;
                }
            }
            // Printing the answer
            System.out.print("Minimum number of substrings are : " + (ans) + "\n");
            test_cases--;
        }
    }
}
