package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class ViewOfTheTree {

    public static void leftView(TreeNodeGeneric root){
        Queue<TreeNodeGeneric> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNodeGeneric node = q.poll();
                if(i == 0 ){
                    System.out.print(node.val + " ");
                }

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
    }

    public static void rightView(TreeNodeGeneric root){
        Queue<TreeNodeGeneric> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNodeGeneric node = q.poll();
                if(i == size - 1 ){
                    System.out.print(node.val + " ");
                }

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
    }

    public static void topView(TreeNodeGeneric root){
        Queue<ColumnLevel> q = new LinkedList<>();
        q.add(new ColumnLevel(root, 0));
        int column = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        while (!q.isEmpty()){
          ColumnLevel c = q.poll();
          if(!map.containsKey(c.column)){
              map.put(c.column, c.node.val);
          }

          if(c.node.left != null){
              q.add(new ColumnLevel(c.node.left, column -1));
          }

            if(c.node.right != null){
                q.add(new ColumnLevel(c.node.right, column + 1));
            }
        }

        System.out.println(map);
    }

    static class ColumnLevel{
        public TreeNodeGeneric node;
        public int column;

        public ColumnLevel(TreeNodeGeneric node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public static void main(String[] args) {
        TreeNodeGeneric root = TreeNodeGeneric.getTree();
        leftView(root);
        System.out.println();
        rightView(root);
        System.out.println();
        topView(root);
        System.out.println();
    }
}
