package misc.leetcode.problem2;

public class Solution {

    public Solution() {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode tail = temp;
        int carry = 0;

        while( l1 != null || l2 != null || carry != 0 ){
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;

        }
        ListNode result = temp.next;
        temp.next = null;

        return result;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode prev = head;

        for (int i = 0; i < n; i++) {
            if (current == null) {
                return null;
            }
            current = current.next;
        }
        if ( current == null ) {
            head = head.next;
            return head;
        }
        while (current.next != null) {
            current = current.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return head;

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode tail = temp;

        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null || l2 != null) {
            if ( l1 == null ) {
                ListNode newNode = new ListNode(l2.val);
                tail.next = newNode;
                l2 = l2.next;
                continue;
            }
            if ( l2 == null ) {
                ListNode newNode = new ListNode(l1.val);
                tail.next = newNode;
                l1 = l1.next;
                continue;
            }
            if ( l1.val < l2.val ) {
                ListNode newNode = new ListNode(l1.val);
                tail.next = newNode;
                l1 = l1.next;
            } else {
                ListNode newNode = new ListNode(l2.val);
                tail.next = newNode;
                l2 = l2.next;
            }
                tail = tail.next;

        }
        ListNode result = temp.next;
        temp.next = null;

        return result;

    }

    public void reverseBetween (ListNode head, int m, int n) {
        if (head == null) return;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0 ; i < m - 1 ; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        for ( int j = 0 ; j < (n - m) ; j++) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        head = dummy.next;
    }

}

