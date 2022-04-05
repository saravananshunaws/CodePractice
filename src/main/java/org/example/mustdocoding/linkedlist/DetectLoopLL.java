package org.example.mustdocoding.linkedlist;

import org.example.generic.NodeGeneric;

public class DetectLoopLL {
    static NodeGeneric head;

    static void detectLoop() {
        NodeGeneric slow_p = head, fast_p = head;
        int flag = 0;
        while (slow_p != null && fast_p != null  && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Loop found");
        else
            System.out.println("Loop not found");
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {

        detectLoop();
    }
}
