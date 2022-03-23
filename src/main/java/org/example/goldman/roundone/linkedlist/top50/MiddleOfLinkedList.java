package org.example.goldman.roundone.linkedlist.top50;

import org.example.goldman.roundone.linkedlist.NodeGM;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        NodeGM head = new NodeGM(10);
        head.next = new NodeGM(20);
        head.next.next = new NodeGM(30);
        head.next.next.next = new NodeGM(40);
        head.next.next.next.next = new NodeGM(50);
        head.next.next.next.next.next = new NodeGM(60);
        NodeGM.printList(head);

        NodeGM slow = head, fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle :: " + slow.data);
    }
}
