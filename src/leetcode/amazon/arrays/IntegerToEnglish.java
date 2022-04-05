package leetcode.amazon.arrays;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglish {
    private static final String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    private static final String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static final String[] belowHundred = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        return helper(num).trim();
    }

    private static String helper(int num) {
        String ans = "";
        if (num < 10)
            ans = belowTen[num];
        else if (num < 20)
            ans = belowTwenty[num - 10];
        else if (num < 100)
            ans = belowHundred[num / 10] + " " + helper(num % 10);
        else if (num < 1000)
            ans = belowTen[num / 100] + " Hundred " + helper(num % 100);
        else if (num < 1000000)
            ans = helper(num / 1000) + " Thousand " + helper(num % 1000);
        else if (num < 1000000000)
            ans = helper(num / 1000000) + " Million " + helper(num % 1000000);
        else
            ans = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        return ans.trim();
    }
}
