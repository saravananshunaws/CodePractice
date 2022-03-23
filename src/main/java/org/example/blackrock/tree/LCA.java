package org.example.blackrock.tree;

public class LCA {

    public static TreeNodeBR lca(TreeNodeBR root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        if (root.val == val1 || root.val == val2) {
            return root;
        }

        TreeNodeBR lca1 = lca(root.left, val1, val2);
        TreeNodeBR lca2 = lca(root.left, val1, val2);

        if (lca1 != null && lca2 != null) {
            return root;
        }

        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }

    public static void main(String[] args) {
        TreeNodeBR root = TreeNodeBR.getTree();
        TreeNodeBR result = lca(root, 20, 60);
        System.out.println("Result:: " + result.val);
    }
}
