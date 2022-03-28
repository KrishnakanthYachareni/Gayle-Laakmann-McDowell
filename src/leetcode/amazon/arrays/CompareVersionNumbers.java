package leetcode.amazon.arrays;

/**
 * https://leetcode.com/problems/compare-version-numbers/
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {
        int ans = compareVersion("1.0.1", "1");
        System.out.println(ans);
    }

    /**
     * The first idea is to split both strings by dot character into chunks and then compare the chunks one by one.
     * That works fine if the number of chunks is the same for both versions. If not, we need to pad the shorter string by adding .0
     * at the end of the string with fewer chunks one or several times, so that the number of chunks will be the same.
     */
    public static int compareVersion(String version1, String version2) {
        String[] ar1 = version1.split("\\.");
        String[] ar2 = version2.split("\\.");

        int num1, num2, n = ar1.length, m = ar2.length;
        for (int i = 0; i < Math.max(n, m); i++) {
            num1 = i < n ? Integer.parseInt(ar1[i]) : 0;
            num2 = i < m ? Integer.parseInt(ar2[i]) : 0;
            if (num1 != num2)
                return num1 < num2 ? -1 : 1;
        }
        return 0;
    }
}
