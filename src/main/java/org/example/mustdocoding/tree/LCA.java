package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.*;

public class LCA {
    public static void main(String args[]) {
        TreeNodeGeneric root = TreeNodeGeneric.getTree();
        TreeNodeGeneric lca = lcaRecursive(root, 10, 30);
        System.out.println("LCA :: " + lca.val);
    }

    public static TreeNodeGeneric lcaRecursive(TreeNodeGeneric root, int n1, int n2) {
        if (root == null) return null;

        if (root.val == n1 || root.val == n2) {
            return root;
        }

        TreeNodeGeneric lca1 = lcaRecursive(root.left, n1, n2);
        TreeNodeGeneric lca2 = lcaRecursive(root.right, n1, n2);

        if (lca1 != null && lca2 != null) {
            return root;
        } else if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }


    public TreeNodeGeneric lowestCommonAncestor(TreeNodeGeneric root, TreeNodeGeneric p, TreeNodeGeneric q) {
        Deque<TreeNodeGeneric> stack = new ArrayDeque<>();
        Map<TreeNodeGeneric, TreeNodeGeneric> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNodeGeneric node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNodeGeneric> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
