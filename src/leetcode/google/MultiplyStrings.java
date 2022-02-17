package leetcode.google;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String ans = multiply("123", "0");
        System.out.println(ans);
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int n = num2.length() - 1;
        for (int j = n; j >= 0; j--) {
            StringBuilder im = multiplyOneDigit(num1, num2.charAt(j));

            // Multiplying with 10 for each digit (Basic multiplication)
            for (int i = j; i < n; i++)
                im.append("0");
            ans = add(ans, im);
        }

        // if result contains all 0's then should return one 0
        return ans;
    }

    /**
     * This method multiply the given number as a string and single digit number
     */
    public static StringBuilder multiplyOneDigit(String num1, char digit) {
        StringBuilder ans = new StringBuilder();
        int cary = 0, current;
        for (int i = num1.length() - 1; i >= 0; i--) {
            current = cary + (num1.charAt(i) - '0') * (digit - '0');
            cary = current / 10;
            ans.insert(0, current % 10);
        }
        if (cary != 0)
            ans.insert(0, cary);

        return ans;
    }

    /**
     * Adding two numbers for the given two strings
     */
    public static String add(String num1, StringBuilder num2) {
        StringBuilder bf = new StringBuilder();
        int m = num1.length(), n = num2.length(), cary = 0, current;
        int i = m - 1, j = n - 1;

        while (i >= 0 || j >= 0) {
            int x1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int x2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            current = cary + x1 + x2;
            cary = current / 10;
            bf.insert(0, current % 10);
            i--;
            j--;
        }
        if (cary != 0)
            bf.insert(0, cary);
        return bf.toString();
    }
}
