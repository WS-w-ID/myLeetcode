class Solution {
    public void setZeroes(int[][] matrix) {
        /** 两个标记数组分别记录每列每行
         */
        int m=matrix.length, n=matrix[0].length;
        int[] vertical = new int[n], horizontal = new int[m];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(matrix[i][j] == 0){
                    vertical[j] = 1;
                    horizontal[i] = 1;
                }
            }
        }
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(vertical[j]==1 || horizontal[i]==1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
