package leetcode.microsoft.arrays;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//        System.out.println(isPalindrome(s));
        System.out.println(myAtoi("4193 with words"));
    }

    /*public static boolean isPalindrome(String s) {
        StringBuilder st = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                st.append(Character.toLowerCase(ch));
            }
        }
        return st.toString().equals(st.reverse().toString());
    }*/

    public static int myAtoi(String s) {
        long ans = 0;
        boolean isNegative = false;

        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            if ('+' == ch) {
                i++;
            } else if (ans == 0 && (Character.isLetter(ch) || '.' == ch)) {
                break;
            } else if (ans != 0 && (Character.isLetter(ch) || '.' == ch)) {
                break;
            } else if (Character.isWhitespace(ch)) {
                i++;
            } else if (ch == '-') {
                isNegative = true;
                i++;
            } else if (Character.isDigit(ch)) {
                ans = ans * 10 + Character.getNumericValue(ch);
                i++;
            }
        }
        if (ans < -2147483648) {
            return -2147483648;
        }
        if (ans > 2147483647) {
            return -2147483648;
        }
        return (int) (isNegative ? -1 * ans : ans);
    }


}
