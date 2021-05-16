package leetcode.lc202105;

/**
 * 289. Game of Life
 * https://leetcode.com/problems/game-of-life/
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/5/16
 */
public class LC289 {
    public void gameOfLife(int[][] board) {

        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                if (i > 0 && (board[i - 1][j] == 2 || board[i - 1][j] == 1)) {
                    count++;
                }
                if (i < row - 1 && (board[i + 1][j] == 2 || board[i + 1][j] == 1)) {
                    count++;
                }
                if (j > 0 && (board[i][j - 1] == 2 || board[i][j - 1] == 1)) {
                    count++;
                }
                if (j < col - 1 && (board[i][j + 1] == 2 || board[i][j + 1] == 1)) {
                    count++;
                }
                if (i > 0 && j > 0 && (board[i - 1][j - 1] == 2 || board[i - 1][j - 1] == 1)) {
                    count++;
                }
                if (i > 0 && j < col - 1 && (board[i - 1][j + 1] == 2 || board[i - 1][j + 1] == 1)) {
                    count++;
                }
                if (i < row - 1 && j > 0 && (board[i + 1][j - 1] == 2 || board[i + 1][j - 1] == 1)) {
                    count++;
                }
                if (i < row - 1 && j < col - 1 && (board[i + 1][j + 1] == 2 || board[i + 1][j + 1] == 1)) {
                    count++;
                }
                if (board[i][j] == 1 && (count < 2 || count > 3)) board[i][j] = 2;
                if (board[i][j] == 0 && count == 3) board[i][j] = -1;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j]==2) board[i][j]=0;
                if (board[i][j]==-1) board[i][j]=1;
            }
        }

    }
}
