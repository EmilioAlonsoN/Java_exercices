package Stacks;

public class Main {

    public static void main(String[] args) {


        MinStack stack = new MinStack();

        stack.push(6);
        System.out.println(stack.getMin());    // prints 6

        stack.push(7);
        System.out.println(stack.getMin());    // prints 6

        stack.push(8);
        System.out.println(stack.getMin());    // prints 6

        stack.push(5);
        System.out.println(stack.getMin());    // prints 5

        stack.push(3);
        System.out.println(stack.getMin());    // prints 3


        stack.push(10);
        System.out.println(stack.getMin());    // prints 5

    }
}
