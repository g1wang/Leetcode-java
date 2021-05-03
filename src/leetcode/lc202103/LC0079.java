package leetcode.lc202103;

/**
 * Word Search
 * https://leetcode.com/problems/word-search/
 * <p>
 * dfs
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/18 15:42
 */
public class LC0079 {

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean ret = dfs(board, word, 0, i, j);
                if (ret) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int wIndex, int i, int j) {
        if (wIndex == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] == word.charAt(wIndex)) {
            char tmp = board[i][j];
            board[i][j] = '#';
            boolean ret = dfs(board, word, wIndex + 1, i + 1, j)
                    || dfs(board, word, wIndex + 1, i, j + 1)
                    || dfs(board, word, wIndex + 1, i - 1, j)
                    || dfs(board, word, wIndex + 1, i, j - 1);
            board[i][j] = tmp;
            return ret;
        } else return false;
    }

}
