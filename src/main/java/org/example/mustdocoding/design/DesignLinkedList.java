package org.example.mustdocoding.design;

import java.util.*;
import java.math.*;
import java.io.*;

public class DesignLinkedList {
    Node head;
    Node current;

    static class Node{
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data){
        if(head == null){
            head = new Node(data);
            current = head;
            return;
        }

        Node node = new Node(data);
        current.next = node;
        current = node;
    }

    public void addToIndex(int index, int data){
        Node current = head;
        Node prev = null;
        int i = 0;
        while(current != null){
            if(i == index){
                Node node = new Node(data);
                prev.next = node;
                node.next = current;
                break;
            }
            prev = current;
            current = current.next;
            i++;
        }
    }

    public void print(){
        Node current = head;
        while(current != null){
            System.out.print (current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DesignLinkedList ll = new DesignLinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        ll.print();
        ll.addToIndex(1, 10);
        ll.print();
    }

}
