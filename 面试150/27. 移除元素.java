class Solution {
    public int removeElement(int[] nums, int val) {
        // O(2n)滑动窗口; 
        // int pre=0,last=0,len=nums.length;
        // while(last<len){
        //     if(nums[last] != val){
        //         nums[pre++] = nums[last];
        //     }
        //     ++last;
        // }
        // return pre;

        // O(n)双指针
        int left=0, right=nums.length-1;
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right--];
            }
            else
                ++left;
        }
        return left;
    }
}
