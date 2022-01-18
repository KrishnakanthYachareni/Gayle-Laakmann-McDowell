package leetcode.google;


//https://leetcode.com/problems/design-a-stack-with-increment-operation/
//https://leetcode.com/problems/design-a-stack-with-increment-operation/discuss/1690500/Constant-Time-Solution-or-All-three-operationes-takes-only-O(1)-time.

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class CustomStack {
    private final Map<Integer, Integer> map;
    private final Stack<Integer> stack;
    private final int maxSize;

    CustomStack(int maxSize) {
        this.map = new HashMap<>();
        this.stack = new Stack<>();
        this.maxSize = maxSize;
    }

    /**
     * TC = O(1)
     */
    void push(int ele) {
        if (stack.size() == maxSize)
            return;
        stack.push(ele);
    }


    /**
     * if the stack size is not empty and the stack size is present in the map
     * get the value from map and remove the element and add this value to the current top element of the stack.
     * Finally, one bottom element has been incremented by given value, not decrement K (size of stack) and insert the k, same value into map.
     * <p>
     * TC = O(1)
     */
    int pop() {
        if (stack.isEmpty())
            return -1;

        int s = stack.size();
        if (map.containsKey(s)) {
            int value = map.remove(s);
            int res = value + stack.pop();
            increment(stack.size(), value);
            return res;
        } else {
            // if stack size is not in the map, which means no increment is necessary.
            return stack.pop();
        }
    }


    /**
     * Each increment check if the given k is present in Hashmap or not.
     * if present: Simple update the value of the existing one by summing current value.
     * else: check if the stack size exceeds given,
     * if exceeds: take the last element of the stack and increment
     * (To avoid Null pointer exception add the 0 if stack size value is not present in the map)
     * <p>
     * else: simply insert the k and value into map.
     * <p>
     * TC = O(1)
     */
    void increment(int k, int val) {
        if (map.containsKey(k)) {
            map.put(k, map.get(k) + val);
        } else {
            int size = stack.size();
            if (size < k)
                map.put(size, map.getOrDefault(size, 0) + val); // Value 0 is just for avoid NPE
            else
                map.put(k, val);
        }
    }
}

