package datastructures.trees;

public class BinaryTreeDiameter {
    public static void main(String[] args) {
        // Create a sample binary tree for testing
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Call the diameterOfBinaryTree function
        int diameter = diameterOfBinaryTree(root);

        System.out.println("Diameter of the binary tree is: " + diameter);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1]; // Use an array to hold the diameter value
        height(root, diameter);
        return diameter[0];
    }

    public static int height(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);

        // Calculate the diameter based on left and right subtree heights
        diameter[0] = Math.max(diameter[0], lh + rh);

        return Math.max(lh, rh) + 1;
    }
}
