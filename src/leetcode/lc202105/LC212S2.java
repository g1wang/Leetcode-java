package leetcode.lc202105;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. Word Search II
 * https://leetcode.com/problems/word-search-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/18
 */
public class LC212S2 {
    class TrieNode {

        // R links to node children
        private TrieNode[] links;

        private final int R = 26;
        private int childrenCnt = 0;
        private String word;


        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.childrenCnt++;
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.word = word;
            node.setEnd();
        }

        public void remove(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node == null) return;
                node.childrenCnt--;
                if (node.childrenCnt == 0) {
                    TrieNode next = node.get(c);
                    node.put(c, null);
                    node = next;
                } else node = node.get(c);
            }
            if (node != null) node.isEnd = false;
        }


    }

    Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int row = board.length, col = board[0].length;
        List<String> matchList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, trie.root, matchList);
            }
        }
        return matchList;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> matchList) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || node == null) return;
        char c = board[i][j];
        if (c == '#') return;
        board[i][j] = '#';
        if (node.containsKey(c)) {
            if (node.get(c).isEnd) {
                matchList.add(node.get(c).word);
                trie.remove(node.get(c).word);
            }
            node = node.get(c);
            if (node != null) {
                dfs(board, i - 1, j, node, matchList);
                dfs(board, i + 1, j, node, matchList);
                dfs(board, i, j - 1, node, matchList);
                dfs(board, i, j + 1, node, matchList);
            }
        }
        board[i][j] = c;

    }
}
