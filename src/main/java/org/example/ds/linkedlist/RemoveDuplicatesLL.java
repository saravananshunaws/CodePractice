package org.example.ds.linkedlist;

public class RemoveDuplicatesLL {

    public static void RemoveDuplicatesLL(Node head){
        Node slow = head;
        Node fast = head.next;

        while(slow != null && fast != null){
            if(slow.data == fast.data){
                slow.next = fast.next;
                slow = fast.next;
                fast = fast.next.next;
                continue;
            }
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println(head);
    }

    public static void main(String[] args) {
        Node node = LinkedListMain.getDuplicateNodes();
        RemoveDuplicatesLL(node);
    }
}
