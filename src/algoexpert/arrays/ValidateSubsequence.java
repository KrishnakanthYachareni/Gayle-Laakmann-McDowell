package algoexpert.arrays;

import java.util.List;

public class ValidateSubsequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int i = 0, j = 0, n = array.size(), m = sequence.size();
        while (i < n && j < m) {
            if (array.get(i).equals(sequence.get(j))) {
                j++;
            }
            i++;
        }
        return j == m;
    }
}
