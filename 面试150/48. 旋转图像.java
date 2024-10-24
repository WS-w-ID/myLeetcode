class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length, temp;

        for(int i=0; i<n/2; ++i){   // 水平翻转
            for(int j=0; j<n; ++j){
                temp=matrix[n-i-1][j];
                matrix[n-i-1][j]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }

        for(int i=0; i<n; ++i){  // 对角线翻转
            for(int j=0; j<i; ++j){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}
