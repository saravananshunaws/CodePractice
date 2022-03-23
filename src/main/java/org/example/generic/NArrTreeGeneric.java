package org.example.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NArrTreeGeneric {
    public int val;
    public List<NArrTreeGeneric> children;

    public NArrTreeGeneric(int val) {
        this.val = val;
    }

    public NArrTreeGeneric(int val, List<NArrTreeGeneric> children) {
        this.val = val;
        this.children = children;
    }

    public static NArrTreeGeneric getTree() {
        NArrTreeGeneric root = new NArrTreeGeneric(1);

        NArrTreeGeneric node1 = new NArrTreeGeneric(2);
        NArrTreeGeneric node2 = new NArrTreeGeneric(3);
        NArrTreeGeneric node3 = new NArrTreeGeneric(4);
        NArrTreeGeneric node5 = new NArrTreeGeneric(5);
        NArrTreeGeneric node6 = new NArrTreeGeneric(6);

        List<NArrTreeGeneric> list1 = new ArrayList<>(Arrays.asList(node1, node2, node3));
        root.children = list1;

        List<NArrTreeGeneric> list2 = new ArrayList<>(Arrays.asList(node5, node6));
        node1.children = list2;

        return root;
    }
}
