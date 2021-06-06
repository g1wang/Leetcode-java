package wc.wc244;

/*
5776. Determine Whether Matrix Can Be Obtained By Rotation
 */
public class P1 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean match = isMatch(mat, target);
        if (match) return true;
        for (int i = 1; i <= 3; i++) {
            rotate90(mat);
            match = isMatch(mat, target);
            if (match) return true;
        }
        return false;
    }

    boolean isMatch(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (target[j][k] != mat[j][k]) return false;
            }
        }
        return true;
    }

    void rotate90(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[i][n - j - 1];
                mat[i][n - j - 1] = tmp;
            }
        }
    }
}
