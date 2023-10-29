package datastructures.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(7);

        System.out.println("DLL before insert():");
        myDLL.printList();

        myDLL.insert(1, 2);

        System.out.println("\nDLL after insert(2) in middle:");
        myDLL.printList();

        myDLL.insert(0, 0);

        System.out.println("\nDLL after insert(0) at beginning:");
        myDLL.printList();

        myDLL.insert(3, 3);

        System.out.println("\nDLL after insert(4) at end:");
        myDLL.printList();

        myDLL.insert(2, 5);

        System.out.println("\nDLL after insert(5) in middle:");
        myDLL.printList();


    }
}
