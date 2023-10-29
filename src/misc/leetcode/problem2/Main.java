package misc.leetcode.problem2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        ListNode node8 = new ListNode(5);
        ListNode node7 = new ListNode(4, node8);
        ListNode node5 = new ListNode(3, node7);
        ListNode node3 = new ListNode(2, node5);
        ListNode node1 = new ListNode(1,node3); // node1 -> node3 -> node5 , 1 -> 2 -> 3
//        ListNode node1 = new ListNode(2,node5); // node1 -> node5 , 2 -> 4

        ListNode node6 = new ListNode(4);
        ListNode node4 = new ListNode(3,node6);
        ListNode node2 = new ListNode(1,node4); // node2 -> node4 -> node6 , 5 -> 4 -> 7


//      ListNode result;
//      result = solution.addTwoNumbers(node1, node2);
//
//      while(result != null) {
//            System.out.print(result.val + " ");
//            result = result.next;
//        }

//        System.out.println("Before Removal: ");
//        ListNode temp = node1;
//        while(temp != null) {
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
//
//        ListNode result1;
//        result1 = solution.reverseList(node1);
//
//        System.out.println("\nAfter Reverse: ");
//        ListNode temp1 = result1;
//        while(temp1 != null) {
//            System.out.print(temp1.val + " ");
//            temp1 = temp1.next;
//        }

//        ListNode result = solution.removeNthFromEnd(node1, 4);
//        System.out.println("After Removal: ");
//        ListNode temp1 = result;
//        while(temp1 != null) {
//            System.out.print(temp1.val + " ");
//            temp1 = temp1.next;
//        }

//        System.out.println("Before Merging node1: ");
//        ListNode temp = node1;
//        while(temp != null) {
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
//
//        System.out.println("\n Before Merging node2: ");
//        ListNode temp2 = node2;
//        while(temp2 != null) {
//            System.out.print(temp2.val + " ");
//            temp2 = temp2.next;
//        }
//
//        ListNode result = solution.mergeTwoLists(node1, node2);
//        System.out.println("After merging: ");
//        ListNode temp1 = result;
//        while(temp1 != null) {
//            System.out.print(temp1.val + " ");
//            temp1 = temp1.next;
//        }

       solution.reverseBetween(node1,2, 4);
       ListNode temp3 = node1;
        while(temp3 != null) {
            System.out.print(temp3.val + " ");
            temp3 = temp3.next;
        }
    }
}
