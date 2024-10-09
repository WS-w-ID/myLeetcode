class Solution {
    public int removeDuplicates(int[] nums) {
        /**O(n)快慢指针 */
        int fast=1, slow=1, n=nums.length;
        while(fast < n){
            if(nums[fast] != nums[fast-1]){
                nums[slow++] = nums[fast];
            }
            ++fast;
        }
        return slow;
    }
}
