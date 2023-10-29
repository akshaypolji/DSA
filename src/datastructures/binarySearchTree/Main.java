package datastructures.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree mytree = new BinarySearchTree();

        mytree.insert(25);
        mytree.insert(18);
        mytree.insert(57);


        /*
            THE LINES ABOVE CREATE THIS TREE:
                         25
                        / \
                       18   57
        */


        System.out.println("Root: " + mytree.getRoot().value);
        System.out.println("\nRoot->Left: " + mytree.getRoot().left.value);
        System.out.println("\nRoot->Right: " + mytree.getRoot().right.value);

    }
}
