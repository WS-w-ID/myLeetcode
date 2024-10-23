class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m=matrix.length, n=matrix[0].length;
        int top=0, left=0, bottom=m-1, right=n-1, i,j;
        while(top<=m/2 && bottom>=m/2 && left<=n/2 && right>=n/2){
            for(j=left; j<=right; ++j){ // 往右走
                ans.add(matrix[top][j]);
            }
            ++top;
            for(i=top; i<=bottom; ++i){ // 往下走
                ans.add(matrix[i][right]);
            }
            --right;
            if(top > bottom)    // 只有一行的情况
                break;
            for(j=right; j>=left; --j){  // 往左走
                ans.add(matrix[bottom][j]);
            }
            --bottom;
            if(left > right)    // 只有一列的情况
                break;
            for(i=bottom; i>=top; --i){     // 往上走
                ans.add(matrix[i][left]);
            }
            ++left;
        }
        
        return ans;
    }
}
