package chapter1.string;

/**
 * @author Krishnakanth Yachareni
 * @since 08-11-2018
 * <p>
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 * </p>
 * Time complexity : O(n) where n is length of string
 * Space complexity : O(1)
 */
public class IsUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("asdfghjklzxcvbnm")); // true
        System.out.println(isUnique("aasghghggjgjgj")); // false
    }

    private static boolean isUnique(String str) {
        // Since ASCII characters are 128 if string is unique then it shouldn't contains more than 128 chars.
        if (str.length() > 128) {
            return false;
        }
        boolean[] boolArray = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (boolArray[val]) {
                return false;
            }
            boolArray[val] = true;
        }
        return true;
    }
}
