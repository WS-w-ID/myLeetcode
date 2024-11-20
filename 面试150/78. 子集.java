class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, output, ans);
        return ans;
    }

    public void dfs(int[] nums, int start, List<Integer> output, List<List<Integer>> ans){
        ans.add(new ArrayList<>(output));   // 存储上一个状态
        int n = nums.length;
        if(start == n)  // 越界状态
            return ;
        for(int i=start; i<n; ++i){
            output.add(nums[i]);    // 以i开头
            dfs(nums, i+1, output, ans);
            output.remove(output.size()-1);    // 不以i开头
        }
    }
}
