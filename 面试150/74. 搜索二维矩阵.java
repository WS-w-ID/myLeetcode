class Solution {
    /**flatten: [row][col] -> n*row+col   index -> [index/n][index%n]*/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int left=0, right=n*m-1;
        while(left <= right){
            int mid = (left+right)/2;
            int row=mid/n, col=mid%n;
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }
}
