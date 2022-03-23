package org.example.blackrock.linkedlist;

import java.util.*;
import java.math.*;
import java.io.*;

public class ReverseLinkedList {

    public static void reverse(NodeBR head){
        NodeBR prev = null;
        while (head != null){
            NodeBR next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        NodeBR.printList(prev);
    }


    public static void reverseKGroup(NodeBR head, int k){
        NodeBR previous = null;
        NodeBR current = head;

        while(current != null){
            NodeBR lastNodeOfPreviousPart = previous;
            NodeBR lastNodeOfSubList = current;
            for(int i=0; i < k && current != null; i++){
                NodeBR next = current.next;
                head.next = previous;
                previous = current;
                current = next;
            }
            if(lastNodeOfPreviousPart != null){
                lastNodeOfPreviousPart.next = previous;
            }else{
                head = previous;
            }

            lastNodeOfSubList.next = current;
            previous = lastNodeOfSubList;
        }


        NodeBR.printList(head);
    }

    public static void main(String[] args) {
        NodeBR head = new NodeBR(10);
        head.next = new NodeBR(20);
        head.next.next = new NodeBR(30);
        head.next.next.next = new NodeBR(40);
        head.next.next.next.next = new NodeBR(50);
        head.next.next.next.next.next = new NodeBR(60);

        //reverse(head);
        reverseKGroup(head, 3);
    }
}
