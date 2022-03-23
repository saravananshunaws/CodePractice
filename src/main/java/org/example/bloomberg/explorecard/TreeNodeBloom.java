package org.example.bloomberg.explorecard;

import java.util.*;
import java.math.*;
import java.io.*;

public class TreeNodeBloom {
      int val;
      TreeNodeBloom left;
      TreeNodeBloom right;
      TreeNodeBloom() {}
      TreeNodeBloom(int val) { this.val = val; }
      TreeNodeBloom(int val, TreeNodeBloom left, TreeNodeBloom right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
