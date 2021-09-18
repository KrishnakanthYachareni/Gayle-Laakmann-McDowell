package codesignal.interview.practice.arrays;

/**
 * https://app.codesignal.com/interview-practice/task/yM4uWYeQTHzYewW9H
 * Asked in Palantir Technologies
 */
public class IsCryptSolution {
    public static void main(String[] args) {
        String[] crypt = {"A", "A", "A"};
        char[][] solution = {{'A', '0'}};
        boolean ans = isCryptSolution(crypt, solution);
        System.out.println(ans);
    }

    static boolean isCryptSolution(String[] crypt, char[][] solution) {
        for (char[] ch : solution) {
            for (int i = 0; i < crypt.length; i++) {
                crypt[i] = crypt[i].replace(ch[0], ch[1]);
            }
        }
        String w1 = crypt[0], w2 = crypt[1], w3 = crypt[2];
        if (hasLeadingZero(w1) || hasLeadingZero(w2) || hasLeadingZero(w3)) {
            return false;
        }
        return Long.parseLong(w1) + Long.parseLong(w2) == Long.parseLong(w3);
    }

    private static boolean hasLeadingZero(String st) {
        if (st.length() >= 2) {
            return st.charAt(0) == '0';
        }
        return false;
    }
}
