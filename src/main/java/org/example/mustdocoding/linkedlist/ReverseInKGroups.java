package org.example.mustdocoding.linkedlist;

import org.example.generic.NodeGeneric;
import org.example.goldman.roundone.linkedlist.NodeGM;

import java.util.Arrays;

public class ReverseInKGroups {

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

    public static void main(String[] args) {
        NodeGeneric head = NodeGeneric.buildList(Arrays.asList(1, 2, 3, 4, 5, 6));
        int k = 3;
        NodeGeneric previous = null, current = head, new_head = null;
        while (current != null) {
            NodeGeneric subListPrev = previous;
            NodeGeneric subListTail = current;

            for (int i = 0; i < k && current != null; i++) {
                NodeGeneric next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            if (new_head == null) {
                new_head = previous;
            } else {
                subListPrev.next = previous;
            }
            System.out.println("Previous ::" + previous);
            System.out.println("Current ::" + current);
            //NodeGeneric.printList(previous);
            subListTail.next = current;
            previous = subListTail;
            System.out.println();
        }

        NodeGeneric.printList(new_head);
    }
}
