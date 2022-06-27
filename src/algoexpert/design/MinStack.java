package algoexpert.design;


import java.util.Stack;

/*
    Approach 1: Minimum Pairs; Maintain the pair of values in stack
    1. First value represents the original element
    2. Second value represents the minimum so far that is encountered

    while pushing the elements to the stack if current element is less than the top of
    the stack minimum then push this element to the stack of second element.

    Disadvantage: Approach 1 required storing two values in each slot of the underlying Stack. Sometimes though, the minimum values are very repetitive
    then same minimum will be repeatedly stored.
    Tc = O(1), Sc = O(N)
    ------------------------------------------------------------------------------------------------------

    Approach2: Two Stacks;
    1. Stack 1: Should keep track of the order numbers arrived (a standard Stack),
    2. Stack 2: Should keep track of the current minimum and the count of that number (To eliminate the repeated numbers).

    Push():  Items should always be pushed onto the stack1, but they should only be pushed onto the stack2
    if the current element is smaller than the current top of stack1 and if the current element is equals to the top of stack2 then simply increment the count of minimum element

    Pop(): Always pop the element from stack1 and pop the element in stack2 if the top both the
    stack are same and Decrement the count of minimum element in stack2 until it becomes 0 then pop the ele
    Tc = O(1), Sc = O(N)
    ------------------------------------------------------------------------------------------------------

    Link: https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    // Approach 2
    private final Stack<Integer> stack;
    private final Stack<int[]> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val < minStack.peek()[0]) {
            minStack.push(new int[]{val, 1});
        } else if (val == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }

    public void pop() {
        if (minStack.peek()[0] == stack.peek()) {
            minStack.peek()[1]--;
        }

        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }

   /* // Approach 1
    private final Stack<int[]> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int currentMinimum = stack.peek()[1];
            stack.push(new int[]{val, Math.min(val, currentMinimum)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }*/
}
