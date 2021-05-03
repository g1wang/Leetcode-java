package leetcode.lc202103;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Valid Sudoku
 *
 * @author CodeX
 * @version 1.0
 * @date 2021/4/2 16:46
 */
public class LC0036 {
    public static boolean isValidSudoku(char[][] board) {
        Map<Character, List<Position>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (map.containsKey(c)) {
                    List<Position> positions = map.get(c);
                    for (Position p : positions) {
                        if (p.x == i
                                || p.y == j
                                || ((p.x / 3 == i / 3 && p.y / 3 == j / 3) && (Math.abs(p.x - i) < 3 && Math.abs(p.y - j) < 3))) {
                            return false;
                        }
                    }
                    positions.add(new Position(i, j));
                } else {
                    List<Position> positions = new ArrayList<>();
                    positions.add(new Position(i, j));
                    map.put(c, positions);
                }
            }
        }
        return true;

    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(chars));
    }
}
