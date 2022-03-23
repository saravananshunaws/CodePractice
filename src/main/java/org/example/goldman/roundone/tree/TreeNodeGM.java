package org.example.goldman.roundone.tree;

public class TreeNodeGM {
    public int val;
    public TreeNodeGM left;
    public TreeNodeGM right;
    public TreeNodeGM next;

    TreeNodeGM(int x) {
        val = x;
        left = right = next = null;
    }

    public static TreeNodeGM getTree() {
        TreeNodeGM rootNode =new TreeNodeGM(40);
        TreeNodeGM node20=new TreeNodeGM(20);
        TreeNodeGM node10=new TreeNodeGM(10);
        TreeNodeGM node30=new TreeNodeGM(30);
        TreeNodeGM node60=new TreeNodeGM(60);
        TreeNodeGM node50=new TreeNodeGM(50);
        TreeNodeGM node70=new TreeNodeGM(70);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;
        return rootNode;
    }

    @Override
    public String toString() {
        return  val+"" ;
    }
}