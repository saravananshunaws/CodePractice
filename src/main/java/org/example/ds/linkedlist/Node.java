package org.example.ds.linkedlist;

import java.util.Objects;

public class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }

    @Override
    public boolean equals(Object o) {
        Node node = (Node) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
