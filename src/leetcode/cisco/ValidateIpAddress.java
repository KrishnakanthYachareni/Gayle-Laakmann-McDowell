package leetcode.cisco;

import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/validate-ip-address/
 */
public class ValidateIpAddress {
    public static void main(String[] args) {
        String ipv4 = "172.16.254.1";
        String ipv6 = "2001:0db8:85a3:0:0:8A2E:0370:7334";

        System.out.println(validIPAddress(ipv4));
        System.out.println(validIPAddress(ipv6));
    }

    public static String validIPAddress(String queryIP) {
        String ipv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern ipv4Pattern = Pattern.compile("^(" + ipv4 + "\\.){3}" + ipv4 + "$");

        String ipv6 = "([0-9a-fA-F]{1,4})";
        Pattern ipv6Pattern = Pattern.compile("^(" + ipv6 + "\\:){7}" + ipv6 + "$");

        if (ipv4Pattern.matcher(queryIP).matches())
            return "IPv4";

        return ipv6Pattern.matcher(queryIP).matches() ? "IPv6" : "Neither";
    }
}
