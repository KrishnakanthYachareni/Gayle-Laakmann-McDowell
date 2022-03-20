package leetcode.amazon;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class Atoi {
    public static void main(String[] args) {
        int ans = myAtoi("");
        System.out.println(ans);
    }

    public static int myAtoi(String s) {
        int sign = 1, result = 0, index = 0, n = s.length();

        //Discard all spaces from the beginning of the input string
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1
        if (index < n && s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check overflow and underflow conditions.
            if ((result > Integer.MAX_VALUE / 10)
                    || (result == Integer.MAX_VALUE / 10
                    && digit > Integer.MAX_VALUE % 10)) {

                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = 10 * result + digit;
            index++;
        }
        return sign * result;
    }
}
