package org.example.blackrock.tree;

public class TreeNodeBR {
    public int val;
    public TreeNodeBR left;
    public TreeNodeBR right;
    public TreeNodeBR next;

    public TreeNodeBR(int x) {
        val = x;
        left = right = next = null;
    }

        /*
                   40
                  /   \
                 20    60
                / \    / \
               10  30  50 70
         */


    public static TreeNodeBR getTree() {
        TreeNodeBR rootNode =new TreeNodeBR(40);
        TreeNodeBR node20=new TreeNodeBR(20);
        TreeNodeBR node10=new TreeNodeBR(10);
        TreeNodeBR node30=new TreeNodeBR(30);
        TreeNodeBR node60=new TreeNodeBR(60);
        TreeNodeBR node50=new TreeNodeBR(50);
        TreeNodeBR node70=new TreeNodeBR(70);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;
        return rootNode;
    }

    public static TreeNodeBR getBSTTree() {
        TreeNodeBR rootNode =new TreeNodeBR(2);
        TreeNodeBR node20=new TreeNodeBR(3);
        TreeNodeBR node10=new TreeNodeBR(4);

        rootNode.right=node20;
        node20.right=node10;
        return rootNode;
    }

    @Override
    public String toString() {
        return  val+"" ;
    }
}