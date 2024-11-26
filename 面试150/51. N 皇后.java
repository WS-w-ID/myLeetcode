class Solution {

    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();
    Set<Integer> columns = new HashSet<>();

    List<List<String>> ans = new ArrayList<>();
    List<Integer> output = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        dfs(0, n);
        
        return ans;
    }

    public void dfs(int row, int n){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; ++i){
                char[] str = new char[n];
                for(int j=0; j<n; ++j){
                    str[j] = '.';
                }
                str[output.get(i)] = 'Q';
                temp.add(String.valueOf(str));
            }
            ans.add(temp);
            return ;
        }



        for(int i=0; i<n; ++i){
            // (row, i)可以放
            if(!diag1.contains(row-i) && !diag2.contains(row+i) && !columns.contains(i)){
                diag1.add(row-i);
                diag2.add(row+i);
                columns.add(i);
                output.add(i);

                dfs(row+1, n);

                diag1.remove(row-i);
                diag2.remove(row+i);
                columns.remove(i);
                output.remove(output.size()-1);
            }
        }

    }
}
