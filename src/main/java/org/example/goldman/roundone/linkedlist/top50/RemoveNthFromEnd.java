package org.example.goldman.roundone.linkedlist.top50;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void RemoveNthFromEnd(ListNode head, int k) {
        int count = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            map.put(count++, curr);
            curr = curr.next;
        }

        System.out.println(count - k);
        ListNode node1 = map.get(count - k -1);
        node1.next = node1.next.next;

        System.out.println(head);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4, new ListNode(5)))));
        RemoveNthFromEnd(l1, 2);
    }
}
