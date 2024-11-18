class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        dfs(n, output, res, 0);
        return res;
    }

    public void dfs(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));    // copy一个
        }
        for (int i = first; i < n; i++) {
            // first为待填位置, i就是可以填到first位置的数的下标
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            dfs(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
