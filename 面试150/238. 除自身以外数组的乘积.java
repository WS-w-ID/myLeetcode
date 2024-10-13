class Solution {
    public int[] productExceptSelf(int[] nums) {
        /** 前缀与后缀 */
        int n=nums.length, i, postfix=1;
        int[] ans = new int[n];
        ans[0] = 1;
        for(i=1; i<n; ++i){
            ans[i] = ans[i-1] * nums[i-1];
        }
        for(i=n-2; i>=0; --i){
            postfix *= nums[i+1];   // 算出后缀
            ans[i] *= postfix;
        }

        return ans;
    }
}
