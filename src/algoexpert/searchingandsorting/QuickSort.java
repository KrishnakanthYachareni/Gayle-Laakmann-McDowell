package algoexpert.searchingandsorting;

/**
 * https://leetcode.com/problems/sort-an-array/
 */
public class QuickSort {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int pivot = nums[(left + right) / 2];
        int index = partition(nums, left, right, pivot);

        quickSort(nums, left, index - 1);
        quickSort(nums, index, right);
    }

    public int partition(int[] nums, int left, int right, int pivot) {
        while (left <= right) {
            while (nums[left] < pivot) {
                left++;
            }

            while (nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
