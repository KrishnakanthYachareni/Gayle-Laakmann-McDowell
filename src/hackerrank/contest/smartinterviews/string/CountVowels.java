package hackerrank.contest.smartinterviews.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a sentence containing only uppercase/lowercase english alphabets and
 * spaces, you have to count the number of words, vowels and consonants.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-
 *       words-vowels-and-consonantsF
 */
public final class CountVowels {
	public static void main(String[] args) {
		String str = "Hello      World";
		countWordsVowelsConsonants(str);
	}

	public static void countWordsVowelsConsonants(String str) {
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		int words = 0, vowels = 0, consonants = 0, i = 0, j = str.length() - 1;
		while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}
		while (j > 0 && str.charAt(j) == ' ') {
			j--;
		}
		while (i <= j) {
			char ch = str.charAt(i);
			if (ch == ' ' || i == j) {
				words++;
			}
			if (set.contains(ch)) {
				vowels++;
			} else if (ch != ' ') {
				consonants++;
			}
			if (ch == ' ') {
				while (i <= j && str.charAt(i) == ' ') { // If Spaces between
															// the words are
															// more
					i++;
				}
			} else {
				i++;
			}
		}
		System.out.println(words + " " + vowels + " " + consonants);
	}
}