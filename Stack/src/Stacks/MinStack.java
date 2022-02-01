package Stacks;

import java.util.Stack;

public class MinStack {

    // main stack to store elements
    private static Stack<Integer> stack;
    //auxiliary stack to store minimum elements
    private static Stack<Integer> minStack;


    // Constructor
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Inserts a given element on top of the stack
    public void push(int val) {
        stack.push(val);
        // if the minStack is empty, push the given element into it
        if (minStack.isEmpty()) {
            minStack.push(val);
        }
        // push the given element into the minStack
        // if it is less than or equal to the current minimum
        else {
            if (minStack.peek() >= val) {
                minStack.push(val);
            }
        }
    }

    // Removes the top element from the stack
    public static void pop() {

        if (minStack.isEmpty()) {
            System.out.println("Stack underflow!!");
            System.exit(-1);
        }
        // remove the top element from the main stack
        int top = stack.pop();

        // remove the top element from the minStack
        // only if it is minimum
        if (top == minStack.peek()) {
            minStack.pop();
        }

    }
    // Returns the top element of the stack
    public int top() {
        return stack.peek();
    }

    // Returns the minimum element from the stack
    public int getMin() {
       if (minStack.isEmpty()) {
           System.out.println("Stack underflow!!");
           System.exit(-1);
       }
       return minStack.peek();
    }
}
