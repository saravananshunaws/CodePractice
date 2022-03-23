package org.example.goldman.roundone.linkedlist;

public class NodeGM {
    public int data;
    public NodeGM next;

    public NodeGM(int x) {
        data = x;
        next = null;
    }

    public static void printList(NodeGM head){
        NodeGM curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }System.out.println();
    }
}
