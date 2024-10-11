class Solution {
    public boolean canJump(int[] nums) {
        /**维护一个能走的最远距离下标，直到遍历到far为止; 当最远距离>=n-1时，true*/
        int n=nums.length, far=0;
        for(int i=0; i<=far; ++i){
            if(far >= n-1)  // 提前结束，不写的话for要改成 i<n && i<=far
                return true;
            far = Math.max(i+nums[i], far);
        }
        return false;

    }
}
