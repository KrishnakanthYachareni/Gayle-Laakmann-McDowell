package codesignal.interview.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codesignal.com/interview-practice/task/pMvymcahZ8dY4g75q/description
 * <p>
 * Asked in Google:
 */
public class FirstDuplicate {
    public static void main(String[] args) {
        int ans = firstDuplicate(new int[]{2, 2,});
        System.out.println(ans);
    }

    /**
     * Solution 1
     * T.C = O(N)
     * <p>
     * S.C = O(N)
     */
    static int firstDuplicate(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int val : a) {
            if (set.contains(val)) {
                return val;
            } else {
                set.add(val);
            }
        }
        return -1;
    }

    /**
     * Solution 2
     * T.C = O(N)
     * <p>
     * S.C = O(1)
     */
    static int solution2(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int val : a) {
            if (set.contains(val)) {
                return val;
            } else {
                set.add(val);
            }
        }
        return -1;
    }
}
