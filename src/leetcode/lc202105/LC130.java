package leetcode.lc202105;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/21
 */
public class LC130 {
    public void solve(char[][] board) {

        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        for (int i = 1; i < col - 1; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '1') board[i][j] = 'O';
            }
        }

    }

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if (board[i][j] == '1' || board[i][j] == 'X') return;
        board[i][j] = '1';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

}
