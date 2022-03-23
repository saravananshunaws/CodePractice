package org.example.generic;

public class TreeNodeGeneric {
    public int val;
    public TreeNodeGeneric left;
    public TreeNodeGeneric right;
    public TreeNodeGeneric next;

    public TreeNodeGeneric(int x) {
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


    public static TreeNodeGeneric getTree() {
        TreeNodeGeneric rootNode =new TreeNodeGeneric(40);
        TreeNodeGeneric node20=new TreeNodeGeneric(20);
        TreeNodeGeneric node10=new TreeNodeGeneric(10);
        TreeNodeGeneric node30=new TreeNodeGeneric(30);
        TreeNodeGeneric node60=new TreeNodeGeneric(60);
        TreeNodeGeneric node50=new TreeNodeGeneric(50);
        TreeNodeGeneric node70=new TreeNodeGeneric(70);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;
        return rootNode;
    }

    public static TreeNodeGeneric getTreeWithNegates() {
        TreeNodeGeneric rootNode =new TreeNodeGeneric(-10);
        TreeNodeGeneric node9=new TreeNodeGeneric(9);
        TreeNodeGeneric node20=new TreeNodeGeneric(20);
        TreeNodeGeneric node15=new TreeNodeGeneric(15);
        TreeNodeGeneric node7=new TreeNodeGeneric(7);

        rootNode.left=node9;
        rootNode.right=node20;

        node20.left=node15;
        node20.right=node7;
        return rootNode;
    }

    public static TreeNodeGeneric getBSTTree() {
        TreeNodeGeneric rootNode =new TreeNodeGeneric(2);
        TreeNodeGeneric node20=new TreeNodeGeneric(3);
        TreeNodeGeneric node10=new TreeNodeGeneric(4);

        rootNode.right=node20;
        node20.right=node10;
        return rootNode;
    }

    @Override
    public String toString() {
        return  val+"" ;
    }
}