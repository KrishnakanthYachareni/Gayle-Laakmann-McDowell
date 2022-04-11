package leetcode.amazon.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class ReorderLogs {
    public static void main(String[] args) {
        String s = "dig1 8 1 5 1";
        String[] ar = s.split(" ", 2);
        System.out.println(Arrays.toString(ar));
    }

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> logComparator = (log1, log2) -> {
            String[] split1 = log1.split(" ", 2); // split into two parts, identifier, content
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // case 1). both logs are letter-logs
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                    return cmp;
                // logs of same content, compare the identifiers
                return split1[0].compareTo(split2[0]);
            }

            // case 2). one of logs is digit-log
            if (!isDigit1)
                return -1; // the letter-log comes before digit-logs
            else if (!isDigit2)
                return 1;
            else
                return 0; // case 3). both logs are digit-log
        };

        Arrays.sort(logs, logComparator);
        return logs;
    }
}
