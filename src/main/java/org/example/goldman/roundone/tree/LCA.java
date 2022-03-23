package org.example.goldman.roundone.tree;

public class LCA {
    public static void main(String args[]) {
        TreeNodeGM root = TreeNodeGM.getTree();
        TreeNodeGM lca =lca(root, 10 , 30);
        System.out.println("LCA :: " + lca.val);
    }

    public static TreeNodeGM lca(TreeNodeGM root, int n1, int n2) {
        if(root == null) return null;

        if(root.val == n1 || root.val == n2){
            return root;
        }

        TreeNodeGM lca1 = lca(root.left, n1, n2);
        TreeNodeGM lca2 = lca(root.right, n1, n2);

        if(lca1 != null && lca2 != null){
            return root;
        }
        else if(lca1 != null){
            return lca1;
        }else {
            return lca2;
        }
    }
}
