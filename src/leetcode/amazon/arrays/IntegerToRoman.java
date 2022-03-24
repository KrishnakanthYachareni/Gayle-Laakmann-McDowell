package leetcode.amazon.arrays;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        String ans = intToRoman(1994);
        System.out.println(ans);
    }

    /**
     * 1. The representation should use the largest possible symbols, working from the left.
     * 2. So to represent a given integer, we look for the largest symbol that fits into it.
     * 3. We subtract that, and then look for the largest symbol that fits into the remainder, and so on until the remainder is 0.
     * 4. Each of the symbols we take out are appended onto the output Roman Numeral string.
     */
    public static String intToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
