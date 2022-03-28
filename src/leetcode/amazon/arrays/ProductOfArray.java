package leetcode.amazon.arrays;

public class ProductOfArray {
    public static void main(String[] args) {

    }

    /**
     * TC = O(N), SC = O(1)
     * <p>
     * The only change in this approach is that we don't explicitly build the suffix array from before.
     * Instead, we simply use a variable to keep track of the running product of elements to the right,
     * and we keep updating the answer array by doing answer[i] = answer[i] * suffix
     * For a given index i, answer[i] contains the product of all the elements to the left
     * and suffix would contain product of all the elements to the right. We then update suffix as suffix = suffix * nums[i]
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] * nums[i - 1];

        int[] ans = new int[n];
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = prefix[i] * suffix;
            suffix *= nums[i];
        }
        return ans;
    }

    /**
     * 1. Take prefix product array
     * 2. suffix product array
     * 3. Then for each index multiply prefix product * suffix product gives the product of array which doesn't include
     * element itself.
     * <p>
     * TC = O(N), SC = (N)
     */
    // TC = O(N), SC = O(N)
    /*public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] * nums[i - 1];

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] * nums[i + 1];

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }*/
}
