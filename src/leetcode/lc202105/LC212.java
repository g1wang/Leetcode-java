package leetcode.lc202105;

import java.util.*;

/**
 * 212. Word Search II
 * https://leetcode.com/problems/word-search-ii/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/18
 */
public class LC212 {

    int row, col;

    public List<String> findWords(char[][] board, String[] words) {
        row = board.length;
        col = board[0].length;
        Set<Integer> visited = new HashSet<>();
        Set<String> matchSet = new HashSet<>();
        List<String> wordList = new ArrayList<>();

        for (String word : words) {
            wordList.add(word);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, 0, wordList, matchSet,visited);
            }
        }
        return new ArrayList<>(matchSet);
    }

    private void dfs(char[][] board, int i, int j, int idx, List<String> wordList,  Set<String> matchSet, Set<Integer> visited) {
        if (i < 0 || i >= row || j < 0 || j >= col || wordList.isEmpty()) return;
        int pos = i * col + j;
        if (visited.contains(pos)) return;
        char c = board[i][j];
        visited.add(pos);
        List<String> matchList = new ArrayList<>();
        for (String s : wordList) {
            if (matchSet.contains(s)) continue;
            if (s.charAt(idx) == c) {
                if (s.length() - 1 == idx) {
                    matchSet.add(s);
                }
                else matchList.add(s);
            }
        }
        dfs(board, i - 1, j, idx + 1, matchList, matchSet, visited);
        dfs(board, i + 1, j, idx + 1, matchList, matchSet, visited);
        dfs(board, i, j - 1, idx + 1, matchList, matchSet, visited);
        dfs(board, i, j + 1, idx + 1, matchList, matchSet, visited);
        visited.remove(pos);

    }
}
