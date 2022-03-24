package leetcode.amazon.arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * {@link https://leetcode.com/problems/median-of-two-sorted-arrays/}
 */
//TODO: Incomplete
public final class MedianOfSortedArrays {

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {1};
        double ans = findMedianSortedArrays(a, b);
        System.out.println(ans);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int low = 0, high = 0, mid = 0;
        if (n != 0 && m != 0) {
            low = Math.min(nums1[0], nums2[0]);
            high = Math.max(nums1[n - 1], nums2[m - 1]);
        }
        while (low <= high) {
            mid = (low + high) / 2;
            int smallCount = f1(nums1, n, mid) + f1(nums2, m, mid);
            int greaterCount = f2(nums1, n, mid) + f2(nums2, m, mid);
            if (smallCount > greaterCount) {
                high = mid - 1;
            } else if (smallCount < greaterCount) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return (mid + mid - 1) / 2.0;
    }

    private static int f1(int[] ar, int n, int x) {
        int low = 0, high = n - 1, mid, ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (ar[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid + 1;
            }
        }
        return ans;
    }

    private static int f2(int[] ar, int n, int x) {
        int low = 0, high = n - 1, mid, ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (ar[mid] > x) {
                high = mid - 1;
                ans = n - mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
