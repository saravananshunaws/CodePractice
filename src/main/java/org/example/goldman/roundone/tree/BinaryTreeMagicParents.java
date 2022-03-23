package org.example.goldman.roundone.tree;

import java.io.*;
import java.util.*;

public class BinaryTreeMagicParents {
    static class TreeNode{
        int val;
        TreeNode left = null, right = null;
        TreeNode(int val){
            this.val = val;
        }
    }
    static int sumParents = 0;
    static void buildTree(TreeNode root, int val, String s)
    {
        int n = s.length();
        TreeNode node = root;
        for(int i=0; i<n-1; i++)
        {
            if(s.charAt(i) == 'L')
                node = node.left;
            else node = node.right;
        }
        TreeNode child = new TreeNode(val);
        if(s.charAt(n-1) == 'L')
            node.left = child;
        else node.right = child;
    }

    static int checkMagicParent(TreeNode node)
    {
        if(node == null)
            return 0;
        int lsum = checkMagicParent(node.left);
        int rsum = checkMagicParent(node.right);
        if(lsum == 0)
            return node.val + rsum;
        if(rsum == 0)
            return node.val + lsum;
        if((lsum%2 == 0 && rsum%2 != 0) || (lsum%2 != 0 && rsum%2 == 0))
            sumParents += node.val;
        return node.val + lsum + rsum;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        TreeNode root = new TreeNode(x);
        for(int i=0; i<n-1; i++)
        {
            String[] s = br.readLine().split(" ");
            int y = Integer.parseInt(s[1]);
            buildTree(root, y, s[0]);
        }
        sc.close();
        br.close();
        checkMagicParent(root);
        System.out.print(sumParents);
    }
}
