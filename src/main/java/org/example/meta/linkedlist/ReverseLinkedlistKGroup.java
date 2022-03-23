package org.example.meta.linkedlist;

import org.example.generic.NodeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class ReverseLinkedlistKGroup {
    public static void main(String[] args) {
        NodeGeneric head = NodeGeneric.buildList(Arrays.asList(1,2,3,4,5,6));
        NodeGeneric current = head, previous = null, new_head = null;
        int  k =3;
        while(current != null){
            NodeGeneric ptr = previous;
            NodeGeneric subList = current;

            for(int i=0; i < k && current != null;i++){
                NodeGeneric next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if(ptr == null){
                new_head = previous;
            } else{
                ptr.next = previous;
            }
            subList.next = current;
            previous = subList;
        }

        NodeGeneric.printList(new_head);
    }
}
