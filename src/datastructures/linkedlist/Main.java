package datastructures.linkedlist;

public class Main {
    public static void main(String[] args){
        LinkedList one = new LinkedList(4);

        one.getHead();
        one.getTail();
        one.getLength();

        System.out.println("----------------------------------");
        System.out.println("Linked List after Initialization:");
        System.out.println("----------------------------------");
        one.printList();

        one.append(11);
        one.append(23);
        one.append(7);

        System.out.println("--------------------------");
        System.out.println("Linked List after Append:");
        System.out.println("--------------------------");
        one.printList();
        one.getHead();
        one.getTail();
        one.getLength();

        System.out.println(one.removeLast().value);

        System.out.println("-----------------------------");
        System.out.println("Linked List after RemoveLast:");
        System.out.println("-----------------------------");
        one.printList();
        one.getHead();
        one.getTail();
        one.getLength();

        System.out.println("Remove Last: " + one.removeLast().value); // length > 1
        System.out.println("Remove Last: " + one.removeLast().value); // length = 1
        System.out.println("Remove Last: " + one.removeLast()); // length = 0

        one.prepend(31);
        System.out.println("-----------------------------");
        System.out.println("Linked List after prepend first element:");
        System.out.println("-----------------------------");
        one.printList();
        one.getHead();
        one.getTail();
        one.getLength();

        one.prepend(35);
        one.prepend(39);

        System.out.println("-----------------------------");
        System.out.println("Linked List after RemoveLast:");
        System.out.println("-----------------------------");
        one.printList();
        one.getHead();
        one.getTail();
        one.getLength();

        System.out.println("Remove First: " + one.removeFirst().value);
        System.out.println("Remove First: " + one.removeFirst().value);
        System.out.println("Remove First: " + one.removeFirst().value);

        System.out.println("-----------------------------");
        System.out.println("Linked List after RemoveFirst:");
        System.out.println("-----------------------------");
        one.printList();
        one.getHead();
        one.getTail();
        one.getLength();

        one.append(11);
        one.append(23);
        one.append(7);

        System.out.println("-----------------------------");
        System.out.println("Get");
        System.out.println("-----------------------------");
        System.out.println(one.get(3));
        System.out.println(one.get(2).value);
        System.out.println(one.get(1).value);
        System.out.println(one.get(0).value);
        System.out.println(one.get(-1));

        one.printList();

        if (one.set(-1,30)) {
            one.printList();
        } else {
            System.out.println("Invalid Index");
        }

        one.printList();

        System.out.println("LL before insert():");
        one.printList();

        one.insert(1, 2);

        System.out.println("\nLL after insert(2) in middle:");
        one.printList();

        one.insert(0, 0);

        System.out.println("\nLL after insert(0) at beginning:");
        one.printList();

        one.insert(5, 5);

        System.out.println("\nLL after insert(4) at end:");
        one.printList();

        System.out.println("LL before remove():");
        one.printList();

        System.out.println("\nRemoved node:");
        System.out.println(one.remove(2).value);
        System.out.println("LL after remove() in middle:");
        one.printList();

        System.out.println("\nRemoved node:");
        System.out.println(one.remove(0).value);
        System.out.println("LL after remove() of first node:");
        one.printList();

        System.out.println("\nRemoved node:");
        System.out.println(one.remove(2).value);
        System.out.println("LL after remove() of last node:");
        one.printList();
        one.getHead();
        one.getTail();
        one.getLength();

        System.out.println(one.remove(1).value);
        System.out.println("LL after remove() of last node:");
        one.printList();
        one.getHead();
        one.getTail();
        one.getLength();

        System.out.println(one.remove(1).value);
        System.out.println("LL after remove() of last node:");
        one.printList();
        one.getHead();
        one.getTail();
        one.getLength();

        System.out.println(one.remove(0).value);
        System.out.println("LL after remove() of last node:");
        one.printList();
        one.getHead();
        one.getTail();
        one.getLength();

        one.append(11);
        one.append(23);
        one.append(7);
        one.append(4);

        System.out.println("LL before reverse:");
        one.printList();

        one.reverse();
        System.out.println("LL after reverse:");

        one.printList();

    }
}
