package datastructures.stack;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(4);

        myStack.getTop();
        myStack.getHeight();
        myStack.printStack();

        System.out.println("-------------");

        myStack.printall();

        System.out.println("----ADD Elements i.e. Push ---------");
        myStack.push(23);

        myStack.printall();

        System.out.println("----DELETE Elements i.e. Pop ---------");

        System.out.println(myStack.pop().value);

        myStack.printall();

        System.out.println(myStack.pop());

        myStack.printall();

    }
}
