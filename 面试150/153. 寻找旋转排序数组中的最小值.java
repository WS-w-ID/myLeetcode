class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n == 1 || nums[n-1] > nums[0])   // 只有一个或者整体升序
            return nums[0];
        int left=0, right=n-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[0] <= nums[mid]){   // mid位于左边那部分，即大的升序部分
                left = mid+1;
            }
            else{   // mid位于右边那部分，即小的升序部分
                right = mid-1;
            }
        }
        return nums[left];
    }
}
