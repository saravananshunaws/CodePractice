package org.example.leetcode.explorecard.linkedlist;

public class ReverseKGroup {

    public static void reverseKGroup(ListNode head, int k) {
        ListNode new_head = null, previous = null;
        ListNode current = head;
        boolean isFirstPass = true;
        while (current != null) {
            ListNode kHead = previous;
            ListNode kTail = current;

            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            System.out.println();
            if (isFirstPass) {
                new_head = previous;
                isFirstPass = false;
            } else{
                kHead.next = previous;
            }

            kTail.next = current;
            previous = kTail;
            System.out.println();
        }

        System.out.print("Nodes of the reversed LinkedList are: ");
        while (new_head != null) {
            System.out.print(new_head.val + " ");
            new_head = new_head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        reverseKGroup(head, 3);
    }
}
