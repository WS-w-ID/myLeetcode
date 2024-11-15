class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m=grid.length, n=grid[0].length;
        int fresh = 0;
        // Initialize
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == 1)
                    ++fresh;
                else if(grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }

        // BFS
        int round = 0;
        while(fresh>0 && !queue.isEmpty()){ // 还有新鲜橘子
            int size=queue.size();
            for(int i=0; i<size; ++i){
                int[] orange = queue.poll();
                // Process
                int r=orange[0], c=orange[1];
                if(r>=1 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    queue.offer(new int[]{r-1,c});
                    --fresh;
                }
                if(r<=m-2 && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    queue.offer(new int[]{r+1,c});
                    --fresh;
                }
                if(c>=1 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    queue.offer(new int[]{r,c-1});
                    --fresh;
                }
                if(c<=n-2 && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    queue.offer(new int[]{r,c+1});
                    --fresh;
                }
            }
            ++round;
        }
        if(fresh > 0)
            return -1;
        return round;
    }
}
