package leetcode.google;

/**
 * https://leetcode.com/problems/add-strings/
 */
public class AddStrings {

    // After code refactoring
    public static String add(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int m = num1.length(), n = num2.length(), cary = 0, current;
        int i = m - 1, j = n - 1;

        while (i >= 0 || j >= 0) {
            int x1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int x2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            current = cary + x1 + x2;
            cary = current / 10;
            ans.insert(0, current % 10);
            i--;
            j--;
        }
        if (cary != 0)
            ans.insert(0, cary);
        return ans.toString();
    }

    /*public String addStrings(String num1, String num2) {
        StringBuilder bf = new StringBuilder();
        int m = num1.length(), n = num2.length(), cary = 0, current;
        int i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            current = cary + (Integer.parseInt(String.valueOf(num1.charAt(i)))
                    + Integer.parseInt(String.valueOf(num2.charAt(j))));
            cary = current / 10;
            bf.insert(0, current % 10);
            i--;
            j--;
        }

        // Remaining characters
        while (i >= 0) {
            current = cary + Integer.parseInt(String.valueOf(num1.charAt(i)));
            cary = current / 10;
            bf.insert(0, current % 10);
            i--;
        }

        while (j >= 0) {
            current = cary + Integer.parseInt(String.valueOf(num2.charAt(j)));
            cary = current / 10;
            bf.insert(0, current % 10);
            j--;
        }
        if (cary != 0)
            bf.insert(0, cary);
        return bf.toString();
    }*/
}
