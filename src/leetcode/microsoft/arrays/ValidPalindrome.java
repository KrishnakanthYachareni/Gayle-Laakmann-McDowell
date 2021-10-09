package leetcode.microsoft.arrays;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder st = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                st.append(Character.toLowerCase(ch));
            }
        }
        return st.toString().equals(st.reverse().toString());
    }

    public boolean isPalindrome2(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }

        return true;
    }

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
