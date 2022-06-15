package algoexpert.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * You're given an array of integers and an integer. Write a function that moves
 * all instances of that integer in the array to the end of the array and returns
 * the array.
 * <p>
 * The function should perform this in place (i.e., it should mutate the input
 * array) and doesn't need to maintain the order of the other integers.
 * <p>
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveElementToEnd {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 0, 3, 12);
        List<Integer> ans = moveElementToEnd(list, 0);
        System.out.println(ans);
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int lastNonToMoveEle = 0;
        // If the current element is not toMove, then we need to append it just in front of last non toMove element we found.
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != toMove) {
                array.set(lastNonToMoveEle++, array.get(i));
            }
        }

        //fill remaining array with toMove's
        while (lastNonToMoveEle < array.size()) {
            array.set(lastNonToMoveEle++, toMove);
        }
        return array;
    }

   /* public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int i = 0, j = array.size() - 1;
        while (i < j) {
            while (array.get(j) == toMove && i < j)
                j--;
            if (array.get(i) == toMove) {
                int temp = array.get(j);
                array.set(i, temp);
                array.set(j, toMove);
            }
            i++;
        }
        return array;
    }*/


}
