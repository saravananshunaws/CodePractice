package org.example.mustdocoding.string.trie;

import java.util.*;

public class RemoveSubFolders {
    class Trie {
        boolean isEnd;
        Trie[] children;

        Trie() {
            isEnd = false;
            children = new Trie[26];
        }
    }

    Trie root;
    Set<String> set = new HashSet<>();

    public void insert(String[] folder) {
        for (String f : folder) {
            boolean isSub = false;
            Trie it = root;
            String[] fs = f.substring(1).split("/");
            for (int i = 0; i < fs.length; i++) {
                char[] ch = fs[i].toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    if (it.children[ch[j] - 'a'] == null) it.children[ch[j] - 'a'] = new Trie();
                    it = it.children[ch[j] - 'a'];
                }
                if (it.isEnd) {  // this is a subfolder of already present folder
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                it.isEnd = true;
                set.add(f);
            }
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        root = new Trie();
        Arrays.sort(folder, (a, b) -> (a.length() - b.length()));
        insert(folder);
        return new ArrayList<>(set);

    }

    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b/c", "/a/b/d"};
        RemoveSubFolders removeSubFolders = new RemoveSubFolders();
        System.out.println(removeSubFolders.removeSubfolders(folder));
    }
}
