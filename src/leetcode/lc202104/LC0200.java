package leetcode.lc202104;

/*
200. Number of Islands
https://leetcode.com/problems/number-of-islands/
 */
public class LC0200 {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid,int i,int j){
        int m=grid.length;
        int n = grid[0].length;
        if (i>=m||j>=n||i<0||j<0) return;
        if (grid[i][j]=='1') grid[i][j]='0';
        else return;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
