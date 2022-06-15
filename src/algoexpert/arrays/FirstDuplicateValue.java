package algoexpert.arrays;

public class FirstDuplicateValue {

    /**
     * TC = O(N), SC = O(1)
     * Constant space solution works because of the given array element are in between 1 - n.
     * Taking index of the given elements will be part of the array itself.
     * <p>
     * And as per the question we can make manipulate the array.
     */
    public int firstDuplicateValue(int[] array) {
        for (int val : array) {
            int absValue = Math.abs(val);
            if (array[absValue - 1] < 0)
                return absValue;
            array[absValue - 1] *= -1;
        }
        return -1;
    }

    // TC = O(N), SC = O(N)
    /*public int firstDuplicateValue(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int val : array) {
            if (set.contains(val))
                return val;
            else
                set.add(val);
        }
        return -1;
    }*/
}
