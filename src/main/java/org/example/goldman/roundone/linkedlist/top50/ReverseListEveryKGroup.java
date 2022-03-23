package org.example.goldman.roundone.linkedlist.top50;

import java.util.*;

class ReverseListEveryKGroup {

    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode ReverseListEveryKGroup(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;

        ListNode current = head, previous = null;
        while (current !=  null) {
            ListNode lastNodeOfPreviousPart = previous;
            ListNode kTail = current;
            ListNode next = null;
            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            if (lastNodeOfPreviousPart != null)
                lastNodeOfPreviousPart.next = previous;
            else
                head = previous;

            kTail.next = current;
            previous = kTail;
            System.out.println();
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseListEveryKGroup(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}