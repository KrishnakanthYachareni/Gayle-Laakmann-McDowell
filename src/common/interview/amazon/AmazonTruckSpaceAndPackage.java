/*
 * Copyright (c) 2020. All rights Reserved By Krishnakanth Yachareni
 */

package common.interview.amazon;


import java.util.*;

public class AmazonTruckSpaceAndPackage {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(100, 180, 40, 120, 10);
        System.out.println(solve(250, input));
    }

    private static List<Integer> solve(int truckSpace, List<Integer> packagesSpace) {
        ArrayList<Integer> loadedTruck = new ArrayList<>();
        Map<Integer, Integer> interMediate = new HashMap<>();
        int finisher = Integer.MIN_VALUE;
        truckSpace -= 30;
        for (int i = 0; i < packagesSpace.size(); i++) {
            int val = packagesSpace.get(i);
            if (interMediate.containsKey(truckSpace - val)) {
                int totalLoad = val > truckSpace - val ? val : truckSpace - val;
                if (totalLoad > finisher) {
                    finisher = totalLoad;
                    loadedTruck = new ArrayList<>();
                    loadedTruck.add(interMediate.get(truckSpace - val));
                    loadedTruck.add(i);
                }
            }
            interMediate.putIfAbsent(val, i);
        }
        return loadedTruck;
    }
}
