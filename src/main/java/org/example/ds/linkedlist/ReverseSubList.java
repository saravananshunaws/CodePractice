package org.example.ds.linkedlist;

public class ReverseSubList {

    public static void ReverseSubList(Node head, int p, int q) {
        Node curr = head;
        Node prev = null;
        Node pNode = null, qNode = null;

        for (int i = 0; i < p - 1 && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        Node lastNodeOfFirstPart = prev;
        Node kTail = curr;

        prev = null;
        for (int i = 0; i < q - p + 1 && curr != null; i++) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = prev;
        }
        kTail.next = curr;
    }


    public static void main(String[] args) {
        Node head = LinkedListMain.getNodes();
        ReverseSubList(head, 2, 4);
    }
}
