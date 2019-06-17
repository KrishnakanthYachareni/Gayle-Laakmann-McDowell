/*
 * Copyright (c) 2019. All rights Reserved By Krishnakanth Yachareni
 */

package interview.expedia;

import java.util.Arrays;
import java.util.List;

public class MiniSwaps {

    static int minimumSwaps(List<Integer> popularity) {
        // Write your code here
        int position, swap, count = 0;
        for (int i = 0; i < (popularity.size() - 1); i++) {
            position = i;
            for (int j = i + 1; j < popularity.size(); j++) {
                if (popularity.get(position) < popularity.get(j))
                    position = j;
            }
            if (position != i) {
                swap = popularity.get(i);
                popularity.set(i, popularity.get(position));
                popularity.set(position, swap);
                count++;
            }
        }
        return count;
    }

    static int minimumSwapsWithArrays(List<Integer> popularity) {
        // Write your code here
        Integer[] array = new Integer[popularity.size()];
        array = popularity.toArray(array);
        int position, swap, count = 0;
        for (int i = 0; i < (array.length - 1); i++) {
            position = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[position] < array[j])
                    position = j;
            }
            if (position != i) {
                swap = array[i];
                array[i] = array[position];
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
