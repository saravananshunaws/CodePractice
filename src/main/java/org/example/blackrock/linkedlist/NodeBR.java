package org.example.blackrock.linkedlist;

public class NodeBR {
    public int data;
    public NodeBR next;

    public NodeBR(int x) {
        data = x;
        next = null;
    }

    public static void printList(NodeBR head){
        NodeBR curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }System.out.println();
    }
}
