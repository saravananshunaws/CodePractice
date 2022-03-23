package org.example.generic;

import java.util.List;

public class NodeGeneric {
    public int data;
    public NodeGeneric next;
    public NodeGeneric() {

    }
    public NodeGeneric(int x) {
        data = x;
        next = null;
    }

    @Override
    public String toString() {
        return "data=" + data + ", next=" + next.data;
    }

    public static NodeGeneric buildList() {
        NodeGeneric head = new NodeGeneric(10);
        head.next = new NodeGeneric(20);
        head.next.next = new NodeGeneric(30);
        head.next.next.next = new NodeGeneric(40);
        head.next.next.next.next = new NodeGeneric(50);
        head.next.next.next.next.next = new NodeGeneric(60);
        return head;
    }

    public static NodeGeneric buildList(List<Integer> list) {
        NodeGeneric head = null, current = null;
        for(Integer i  : list){
            if(head == null){
                head = new NodeGeneric(i);
                current = head;
            }else{
                current.next = new NodeGeneric(i);
                current = current.next;
            }
        }
        return head;
    }

    public static void printList(NodeGeneric head) {
        NodeGeneric curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
