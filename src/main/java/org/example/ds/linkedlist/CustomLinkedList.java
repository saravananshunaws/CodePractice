package org.example.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CustomLinkedList {

    Node head = null;
    Node current = null;

    static class Node {
        public Node next;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }


    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            current = head;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
    }

    public void get(int data) {

    }

    public void remove(int data) {
        Node ptr = head, fastPtr = head.next;
        Node prev = null;
        while (ptr != null) {
            // System.out.print(ptr.data + " ");
            if (ptr.data == data) {
                if (prev != null) {
                    prev.next = ptr.next;
                } else {
                    head = ptr.next;
                    ptr = null;
                    break;
                }
            }
            prev = ptr;
            ptr = ptr.next;
        }
    }

    public void display() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.display();
        list.remove(30);
        list.display();
    }
}
