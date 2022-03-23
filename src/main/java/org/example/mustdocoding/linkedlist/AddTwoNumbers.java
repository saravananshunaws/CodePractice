package org.example.mustdocoding.linkedlist;

import org.example.generic.NodeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class AddTwoNumbers {
    public static void main(String[] args) {
        NodeGeneric listNode1 = NodeGeneric.buildList(Arrays.asList(2,4,3));
        NodeGeneric listNode2 = NodeGeneric.buildList(Arrays.asList(5,6,4));
        NodeGeneric head = null, current = null;
        int carry = 0;
        while(listNode1 != null && listNode2 != null){
            int value1 = listNode1.data;
            int value2 = listNode2.data;

            int sum = value1 + value2 + carry;
            carry = sum / 10;
            if(head == null){
                head = new NodeGeneric(sum % 10);
                current = head;
            }else{
                current.next = new NodeGeneric(sum % 10);
                current = current.next;
            }
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
       NodeGeneric.printList(head);
    }
}
