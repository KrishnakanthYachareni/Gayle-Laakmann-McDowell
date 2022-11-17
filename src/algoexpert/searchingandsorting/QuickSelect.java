package algoexpert.searchingandsorting;

public class QuickSelect {

    // TC = O(N), SC = O(1)
    public static int quickselect(int[] array, int k) {
        int position = k - 1;
        return quickSelect(array, 0, array.length - 1, position);
    }

    private static int quickSelect(int[] array, int startIdx, int endIdx, int position) {
        while (true) {
            if (startIdx > endIdx) {
                throw new RuntimeException("Algorithm not supposed to reach here!");
            }
            int pivotIndex = startIdx;
            int leftIdx = startIdx + 1;
            int rightIdx = endIdx;
            while (leftIdx <= rightIdx) {
                if (array[leftIdx] > array[pivotIndex] && array[rightIdx] < array[pivotIndex])
                    swap(array, leftIdx, rightIdx);

                if (array[leftIdx] <= array[pivotIndex])
                    leftIdx++;

                if (array[rightIdx] >= array[pivotIndex])
                    rightIdx--;
            }
            swap(array, pivotIndex, rightIdx);

            if (rightIdx == position) {
                return array[rightIdx];
            } else if (rightIdx < position) {
                startIdx = rightIdx + 1;
            } else {
                endIdx = rightIdx - 1;
            }
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
