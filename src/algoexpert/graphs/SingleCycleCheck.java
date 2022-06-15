package algoexpert.graphs;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        int numElementsVisited = 0;
        int currentIndex = 0;

        while (numElementsVisited < array.length) { // if > array can have more than one cycle
            if (numElementsVisited > 0 && currentIndex == 0)
                return false;
            numElementsVisited++;
            currentIndex = nextIndex(currentIndex, array);
        }
        return currentIndex == 0;
    }

    private static int nextIndex(int currentIndex, int[] array) {
        int jump = array[currentIndex];
        int nextIndex = (currentIndex + jump) % array.length;

        return nextIndex >= 0 ? nextIndex : nextIndex + array.length; // To handle the negative integers as indexes
    }
}
