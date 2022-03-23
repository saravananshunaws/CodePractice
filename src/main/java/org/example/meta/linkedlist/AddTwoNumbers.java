package org.example.meta.linkedlist;

import org.example.generic.NodeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class AddTwoNumbers {
    public static void main(String[] args) {
        NodeGeneric linked1 = NodeGeneric.buildList(Arrays.asList(2,4,3));
        NodeGeneric linked2 = NodeGeneric.buildList(Arrays.asList(5,6,4));

        int carry = 0;
        NodeGeneric result = null, head = null;
        while(linked1 != null && linked2 != null){
            int value1 = linked1.data;
            int value2 = linked2.data;
            int sum = carry + value1 + value2;
            carry = sum /10;
            if(result ==  null){
                result = new NodeGeneric(sum % 10);
                head = result;
            }else{
                result.next = new NodeGeneric(sum % 10);
                result = result.next;
            }
            linked1 = linked1.next;
            linked2 = linked2.next;
        }
        NodeGeneric.printList(head);
    }
}
