class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output  = new ArrayList<>();

        backtrace(ans, output, candidates, 0, target);

        return ans;
    }

    public void backtrace(List<List<Integer>> ans, List<Integer> output, int[] candidates, int index, int sum){
        int n = candidates.length;
        if(index==n || sum<=0){ // 找到结束或者结果超出
            if(sum == 0)    // 找到结束
                ans.add(new ArrayList<>(output));
            return ;
        }

        for(int i=index; i<n; ++i){ // 第index个
            if(candidates[i] > sum) // 优化，提前结束
                continue;
            output.add(candidates[i]);
            backtrace(ans, output, candidates, i, sum - candidates[i]); // 注意是i不是i+1，因为可以重复选
            output.remove(output.size()-1);
        }
    }
}
