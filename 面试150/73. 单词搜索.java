class Solution {
    boolean ans=false;
    public boolean exist(char[][] board, String word) {
        int m=board.length, n=board[0].length;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(board[i][j] == word.charAt(0))
                    dfs(board, i, j, word, 0);
            }
        }
        return ans;
    }

    public void dfs(char[][] board, int row, int col, String word, int index){
        int m=board.length, n=board[0].length;
        if(row<0 || row >=m || col<0 || col>=n || index>=word.length()){    // 越界
            return ;
        }
        if(board[row][col] != word.charAt(index)){  // 不匹配或已访问
            return ;
        }
        if(index == word.length()-1){   // 正常结束
            ans = true;
            return ;
        }

        board[row][col] += 'a'; // 表示已经访问过

        dfs(board, row-1, col, word, index+1);
        dfs(board, row+1, col, word, index+1);
        dfs(board, row, col-1, word, index+1);
        dfs(board, row, col+1, word, index+1);

        board[row][col] -= 'a'; // 回溯
    }
}
