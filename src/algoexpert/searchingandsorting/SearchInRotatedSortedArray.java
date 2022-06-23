package algoexpert.searchingandsorting;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

    /*
        Approach: Apply binary search such a way that where
        1. The left-pointer number is smaller than or equal to the middle number
        then if the target is lies in this sub array search by moving (high = mid - 1)

        2. The right-pointer number is greater than or equal to the middle number then
        if the target lies in between search by moving (low = mid + 1)

        TC = O(log n), SC = O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int potentialMatch = nums[mid];
            int leftValue = nums[low];
            int rightValue = nums[high];

            if (potentialMatch == target) {
                return mid;
            } else if (leftValue <= potentialMatch) {
                if (target < potentialMatch && target >= leftValue) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > potentialMatch && target <= rightValue) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
