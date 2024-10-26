class Solution {
    public void gameOfLife(int[][] board) {
        /**-1过去死现在活, 0过去死现在死, 1过去活现在活, 2过去活现在死 */
        int m=board.length, n=board[0].length;
        int cnt=0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                cnt = sumOfArround(board, i, j, m, n);
                if(board[i][j] > 0){
                    if(cnt<2 || cnt>3)
                        board[i][j] = 2;
                }
                else if(cnt == 3)
                    board[i][j] = -1;
                // System.out.print(cnt+"-"+board[i][j] +"   ");
            }
            // System.out.println("");
        }

        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(board[i][j]==1 || board[i][j]==-1)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }

    public int sumOfArround(int[][] board, int i, int j, int m, int n){
        int cnt=0;
        if(i-1 >= 0){
            cnt += board[i-1][j]>0 ? 1 : 0; // 正上
            if(j-1 >= 0)
                cnt += board[i-1][j-1]>0 ? 1 : 0;   // 左上
            if(j+1 <= n-1)
                cnt += board[i-1][j+1]>0 ? 1 : 0;;   // 右上
        }
        if(i+1 <= m-1){
            cnt += board[i+1][j]>0 ? 1 : 0;; //正下
            if(j-1 >= 0)
                cnt += board[i+1][j-1]>0 ? 1 : 0;;   // 左下
            if(j+1 <= n-1)
                cnt += board[i+1][j+1]>0 ? 1 : 0;;   // 右下
        }
        if(j-1 >= 0)
            cnt += board[i][j-1]>0 ? 1 : 0;; // 正左
        if(j+1 <= n-1)
            cnt += board[i][j+1]>0 ? 1 : 0;; // 正右
        return cnt;
    }
}
