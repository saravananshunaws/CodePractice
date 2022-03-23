package org.example.goldman.roundone.linkedlist;

public class ReverseLinkedList {
    public static void main(String args[]) {
        NodeGM head = new NodeGM(10);
        head.next = new NodeGM(20);
        head.next.next = new NodeGM(30);
        head.next.next.next = new NodeGM(40);
        head.next.next.next.next = new NodeGM(50);
        head.next.next.next.next.next = new NodeGM(60);
        NodeGM.printList(head);
        head = reverseSizeK(head, 2);
        NodeGM.printList(head);
    }

    public static NodeGM reverse(NodeGM head) {
        NodeGM prev = null;
        NodeGM curr = head;

        while (curr != null) {
            NodeGM next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static NodeGM reverseSizeK(NodeGM head, int k) {
        NodeGM curr = head, prevFirst = null;
        boolean isFirstPass = true;
        while (curr != null) {
            NodeGM first = curr, prev = null;
            int count = 0;
            while (curr != null && count < k) {
                NodeGM next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            } else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
        return head;
    }
}
