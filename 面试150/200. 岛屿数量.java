class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length, ans=0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int r, int c){
        int m=grid.length, n=grid[0].length;
        if(r<0 || r>=m || c<0 || c>=n)
            return ;
        if(grid[r][c] != '1')
            return ;

        grid[r][c] = '2';

        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}
