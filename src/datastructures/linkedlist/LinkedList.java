package datastructures.linkedlist;

import misc.leetcode.problem2.ListNode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead(){
        if (head == null){
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail(){
        if (tail == null){
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

    public void append(int value){
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = null;
        }
        length++;
    }

    public Node removeLast(){
        if (length == 0) {

            return null;
        } else if (length == 1) {
            head = null;
            tail = null;
            length-- ;

            return head;

        } else {
            Node temp = head;
            Node prev = head;
            while(temp.next != null){
                prev = temp;
                temp = temp.next;
            }
            tail = prev;
            tail.next = null;
            length-- ;

            return temp;
        }
    }

    public void prepend(int value){
        Node newNode = new Node(value);

        if (length == 0) {
           head = newNode;
           tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length ++;
    }

    public Node removeFirst(){
        if (length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length-- ;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0 ; i < index ; i++ ) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        if (index < 0 || index >= length) {
            return false;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.value = value;
            return true;
        }
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)  {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }

    public Node remove(int index) {
        if ( index < 0 || index >= length) return null;

        if ( index == 0 ) {
            Node temp = removeFirst();
            return temp;
        }
        if ( index == (length - 1)) {
            Node temp = removeLast();
            return temp;
        }
        Node prev = get(index - 1);
        Node temp = prev.next; //Awesomeness ... get has O(n), prev.next will have O(1)
        prev.next = temp.next;
        temp.next = null;
        length-- ;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for ( int i = 0 ; i < length ; i ++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        Node end = head;
        Node middle = head;
        int count = 0;

        while( end != null && end.next != null) {
            end = end.next.next;
            middle = middle.next;
        }
        return middle;
    } // LL: Find Middle Node ( ** Interview Question)

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while ( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ) {
                return true ;
            }
        }
        return false;
    } // LL: Has Loop ( ** Interview Question)

    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for ( int i = 0 ; i < k ; i++) {
            if ( fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    } // LL: Find Kth Node From End ( ** Interview Question)

    public void partitionList(int x) {
        if ( head == null) return ;

        Node before = new Node(0);
        Node after  = new Node(0);
        Node prev1 = before;
        Node prev2 = after;

        Node current = head;

        while (current != null) {

            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }

            current = current.next;

        }

        prev2.next = null;
        prev1.next = after.next;

        head = before.next;

    } // LL: Partition List ( ** Interview Question)

    // public void removeDuplicates() {
    //     if ( head == null ) return ;

    //     Node current = head;
    //     while ( current != null ) {
    //         Node runner = current;
    //         while ( runner.next != null) {
    //             if (runner.next.value == current.value) {
    //                 runner.next = runner.next.next;
    //                 length--;
    //             } else {
    //                 runner = runner.next;
    //             }
    //         }
    //         current = current.next;
    //     }
    // } // LL: Remove Duplicates ( ** Interview Question) - Without Set

    public void removeDuplicates() {
        Set<Integer> seen = new HashSet<>();
        Node prev = null;
        Node current = head;

        while(current != null) {
            if (seen.contains(current.value)) {
                prev.next = current.next;
                length-- ;
            } else {
                seen.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    } // LL: Remove Duplicates ( ** Interview Question) - Using Set

    public void reverseBetween (int m, int n) {
        if (head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 0 ; i < m ; i++) {
            prev = prev.next;
        }

        Node current = prev.next;
        for ( int j = 0 ; j < (n - m) ; j++) {
            Node temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        head = dummy.next;
    } // LL: Reverse Between ( ** Interview Question)

//    public ListNode mergeKLists(ListNode[] lists) {
//        Queue<ListNode> q = new PriorityQueue<ListNode>((a, b) -> a.value - b.value);
//
//        for (ListNode l: lists) {
//            if (l!=null) q.add(l);
//        }
//
//        Node head = new Node(0);
//        Node prev = head;
//
//        while(!q.isEmpty()) {
//            prev.next = q.poll();
//            prev = prev.next;
//            ListNode next = prev.next;
//            if (next != null) {
//                q.add(next);
//            }
//        }
//
//        return head.next;
//
//    }



}


// From Udemy Course
// public class LinkedList {
//
//    private Node head;
//    private Node tail;
//    private int length;
//
//    class Node {
//        int value;
//        Node next;
//
//        Node(int value) {
//            this.value = value;
//        }
//    }
//
//    public LinkedList(int value) {
//        Node newNode = new Node(value);
//        head = newNode;
//        tail = newNode;
//        length = 1;
//    }
//
//    public Node getHead() {
//        return head;
//    }
//
//    public Node getTail() {
//        return tail;
//    }
//
//    public int getLength() {
//        return length;
//    }
//
//    public void printList() {
//        Node temp = head;
//        while (temp != null) {
//            System.out.println(temp.value);
//            temp = temp.next;
//        }
//    }
//
//    public void printAll() {
//        if (length == 0) {
//            System.out.println("Head: null");
//            System.out.println("Tail: null");
//        } else {
//            System.out.println("Head: " + head.value);
//            System.out.println("Tail: " + tail.value);
//        }
//        System.out.println("Length:" + length);
//        System.out.println("\nLinked List:");
//        if (length == 0) {
//            System.out.println("empty");
//        } else {
//            printList();
//        }
//    }
//
//    public void makeEmpty() {
//        head = null;
//        tail = null;
//        length = 0;
//    }
//
//    public void append(int value) {
//        Node newNode = new Node(value);
//        if (length == 0) {
//            head = newNode;
//            tail = newNode;
//        } else {
//            tail.next = newNode;
//            tail = newNode;
//        }
//        length++;
//    }
//
//    public Node removeLast() {
//        if (length == 0) return null;
//        Node temp = head;
//        Node pre = head;
//        while(temp.next != null) {
//            pre = temp;
//            temp = temp.next;
//        }
//        tail = pre;
//        tail.next = null;
//        length--;
//        if (length == 0) {
//            head = null;
//            tail = null;
//        }
//        return temp;
//    }
//
//    public void prepend(int value) {
//        Node newNode = new Node(value);
//        if (length == 0) {
//            head = newNode;
//            tail = newNode;
//        } else {
//            newNode.next = head;
//            head = newNode;
//        }
//        length++;
//    }
//
//    public Node removeFirst() {
//        if (length == 0) return null;
//        Node temp = head;
//        head = head.next;
//        temp.next = null;
//        length--;
//        if (length == 0) {
//            tail = null;
//        }
//        return temp;
//    }
//
//    public Node get(int index) {
//        if (index < 0 || index >= length) return null;
//        Node temp = head;
//        for(int i = 0; i < index; i++) {
//            temp = temp.next;
//        }
//        return temp;
//    }
//
//    public boolean set(int index, int value) {
//        Node temp = get(index);
//        if (temp != null) {
//            temp.value = value;
//            return true;
//        }
//        return false;
//    }
//
//    public boolean insert(int index, int value)  {
//        if (index < 0 || index > length) return false;
//        if (index == 0) {
//            prepend(value);
//            return true;
//        }
//        if (index == length) {
//            append(value);
//            return true;
//        }
//        Node newNode = new Node(value);
//        Node temp = get(index - 1);
//        newNode.next = temp.next;
//        temp.next = newNode;
//        length++;
//        return true;
//    }
//
//    public Node remove(int index) {
//        if (index < 0 || index >= length) return null;
//        if (index == 0) return removeFirst();
//        if (index == length - 1) return removeLast();
//
//        Node prev = get(index - 1);
//        Node temp = prev.next;
//
//        prev.next = temp.next;
//        temp.next = null;
//        length--;
//        return temp;
//    }
//
//    public void reverse() {
//        Node temp = head;
//        head = tail;
//        tail = temp;
//        Node after = temp.next;
//        Node before = null;
//
//        for (int i = 0; i < length; i++) {
//            after = temp.next;
//            temp.next = before;
//            before = temp;
//            temp = after;
//        }
//    }
//
//}
//
