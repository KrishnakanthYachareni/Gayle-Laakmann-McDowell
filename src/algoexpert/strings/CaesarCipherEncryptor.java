package algoexpert.strings;

import java.util.stream.Collectors;

/**
 * Given a non-empty string of lowercase letters and a non-negative integer representing a key, write a function that returns a new string obtained by shifting every letter in the input string by k positions in the alphabet, where k is the key.
 * <p>
 * Note that letters should "wrap" around the alphabet; in other words, the letter z shifted by one returns the letter a.
 */
public class CaesarCipherEncryptor {
    public static void main(String[] args) {
        String ans = caesarCypherEncryptor("xyz", 2);
        System.out.println(ans);
    }

    // TC = O(N), SC = O(N)
    public static String caesarCypherEncryptor(String str, int key) {
       /* StringBuilder cipher = new StringBuilder();
        for (char ch : str.toCharArray()) {
            char shiftedChar = (char) (((ch - 'a' + key) % 26) + 'a');
            cipher.append(shiftedChar);
        }
        return cipher.toString();*/

        return str.chars()
                .mapToObj(ch -> (char) (((ch - 'a' + key) % 26) + 'a'))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
