package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.*;


public class AllNodesDistanceKBinaryTree {

    Map<TreeNodeGeneric, TreeNodeGeneric> parent;

    public List<Integer> distanceK(TreeNodeGeneric root, TreeNodeGeneric target, int K) {
        parent = new HashMap();
        dfs(root, null);

        Queue<TreeNodeGeneric> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNodeGeneric> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNodeGeneric node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNodeGeneric n : queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNodeGeneric par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }

        return new ArrayList<Integer>();
    }

    public void dfs(TreeNodeGeneric node, TreeNodeGeneric par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
