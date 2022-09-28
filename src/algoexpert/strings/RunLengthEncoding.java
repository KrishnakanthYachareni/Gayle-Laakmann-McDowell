package algoexpert.strings;

/*
  Write a function that takes in a non-empty string and returns its run-length encoding.
  From Wikipedia, "run-length encoding is a form of lossless data compression in which runs of data are stored as a single data value
  and count, rather than as the original run." For this problem, a run of data is any sequence of consecutive, identical characters.
  So the run "AAA" would be run-length-encoded as "3A".
  To make things more complicated, however, the input string can contain all sorts of special characters, including numbers.
  And since encoded data must be decodable, this means that we can't naively run-length-encode long runs.
  For example, the run "AAAAAAAAAAAA" (12 As), can't naively be encoded as "12A", since this string can be decoded as either "AAAAAAAAAAAA" or "1AA". Thus, long runs (runs of 10 or more characters) should be encoded in a split fashion; the aforementioned run should be encoded as "9A3A".

  Link:  https://www.algoexpert.io/questions/run-length-encoding
 */
public class RunLengthEncoding {

    public static void main(String[] args) {
        String ans = runLengthEncoding("AAAAAAAAAAAAABBCCCCDD");
        System.out.println(ans);
    }

    // TC = O(N), SC = O(N)
    public static String runLengthEncoding(String s) {
        StringBuilder encoded = new StringBuilder();
        char previousChar = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (count == 9 || s.charAt(i) != previousChar) {
                encoded.append(count).append(previousChar);
                previousChar = s.charAt(i);
                count = 0;
            }
            count++;
        }

        if (count != 0) {
            encoded.append(count).append(previousChar);
        }
        return encoded.toString();
    }
}
