package org.example.ds.linkedlist;

public class LinkedListMain {

    static void reverse(Node current) {
        Node prev = null, next = null;
        Node root = current;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        System.out.println(root);
    }

    static Node recRevL(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        Node rest_head = recRevL(head.next);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.next = temp2;
        System.out.print(head.data + "-->" + temp1.data + "-->" + temp2.data);

        reverse(head);
    }

    public static Node getNodes(){
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        Node temp4 = new Node(50);
        Node temp5 = new Node(60);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        return head;
    }

    public static Node getDuplicateNodes(){
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(20);
        Node temp3 = new Node(40);
        Node temp4 = new Node(40);
        Node temp5 = new Node(60);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        return head;
    }
}


