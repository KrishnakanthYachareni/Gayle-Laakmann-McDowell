/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview;

import java.util.Arrays;
import java.util.List;

//https://stackoverflow.com/questions/55210162/minimum-number-of-swaps-to-sort-an-array
public class MiniSwaps {
    static int minimumSwaps(List<Integer> popularity) {
        // Write your code here
        Integer[] array = new Integer[popularity.size()];
        array = popularity.toArray(array);
        int position, swap, count = 0;
        for (int c = 0; c < (array.length - 1); c++) {
            position = c;

            for (int d = c + 1; d < array.length; d++) {
                if (array[position] < array[d])
                    position = d;
            }
            if (position != c) {
                swap = array[c];
                array[c] = array[position];
                array[position] = swap;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(Arrays.asList(3, 3, 1, 2)));
    }

}
