package algoexpert.design;

public class StackImplementation {
    private final int[] arr;
    private int top;
    private final int capacity;

    StackImplementation(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull())
            throw new RuntimeException("Overflow");

        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Underflow");

        // decrease stack size by 1 and (optionally) return the popped element
        return arr[top--];
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Underflow");

        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1; // or return size() == 0;
    }

    public boolean isFull() {
        return size() == capacity - 1; // or return size() == capacity;
    }
}
