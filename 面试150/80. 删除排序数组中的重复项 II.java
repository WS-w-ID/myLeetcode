class Solution {
    public int removeDuplicates(int[] nums) {
        int fast=2, slow=2, n=nums.length;
        if(n <= 2)
            return n;
        while(fast < n){
            if(nums[fast] != nums[slow-2]){
                nums[slow++] = nums[fast];
            }
            ++fast;
        }
        return slow;
    }
}
