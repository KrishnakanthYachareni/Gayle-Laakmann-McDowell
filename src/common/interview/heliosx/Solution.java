package common.interview.heliosx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    private static final String NEITHER = "Neither";
    private static final String IPV_4 = "IPv4";
    private static final String IPV_6 = "IPv6";


    public static List<String> solveQuestion3(List<String> ips) {
        List<String> out = new ArrayList<>();
        for (String IP : ips) {
            if (IP.chars().filter(ch -> ch == '.').count() == 3) {
                out.add(findIPv4(IP));
            } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
                out.add(findIPv6(IP));
            } else {
                out.add(NEITHER);
            }
        }
        return out;
    }

    public static int solveQuestion2(List<Integer> levels) {
        // Write your code here
        int difference = -1;
        int size = levels.size();
        int max = levels.get(size - 1);
        for (int i = size - 2; i >= 0; i--) {
            if (levels.get(i) > max) {
                max = levels.get(i);
            } else {
                difference = Integer.max(difference, max - levels.get(i));
            }
        }
        return difference;
    }

    public static int solveQuestion1(List<Integer> A) {
        Collections.sort(A);
        int sum = A.get(0), prev = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) <= prev) {
                prev = prev + 1;
                sum = sum + prev;
            } else {
                sum = sum + A.get(i);
                prev = A.get(i);
            }
        }
        return sum;
    }

    private static String findIPv4(String IP) {
        String[] values = IP.split("\\.", -1);
        for (String x : values) {
            if (x.length() == 0 || x.length() > 3) {
                return NEITHER;
            }
            if (x.charAt(0) == '0' && x.length() != 1) {
                return NEITHER;
            }
            for (char ch : x.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return NEITHER;
                }
            }
            if (Integer.parseInt(x) > 255) {
                return NEITHER;
            }
        }
        return IPV_4;
    }

    private static String findIPv6(String ipAdr) {
        String[] values = ipAdr.split(":", -1);
        String hexDec = "0123456789abcdefABCDEF";
        for (String x : values) {
            if (x.length() == 0 || x.length() > 4) {
                return NEITHER;
            }
            for (Character chr : x.toCharArray()) {
                if (hexDec.indexOf(chr) == -1) {
                    return NEITHER;
                }
            }
        }
        return IPV_6;
    }
}
