package datastructures.binarySearchTree;

public class BinarySearchTree {
    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {

        Node newNode = new Node(value);
        if ( root == null ) {
            root = newNode;
            return true;
        } else {
            Node temp = root;
            while(true) {
                if ( temp.value == value ) {
                    return false;
                }
                if ( value < temp.value ) {
                    if ( temp.left == null ) {
                        temp.left = newNode;
                        return true;
                    } else {
                        temp = temp.left;
                    }
                } else if ( value > temp.value ) {
                    if ( temp.right == null ) {
                        temp.right = newNode;
                        return true;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }

    }

    public boolean contains(int value) {
        Node temp = root;
        while(temp != null) {
            if ( temp.value == value ) return true;
            if ( value < temp.value ) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

}
