class Solution {

    int ans_left=-1, ans_right=-1;

    /**两次二分查找 */
    public int[] searchRange(int[] nums, int target) {
        int left=0, right=nums.length-1;

        binarySearch(nums, target, 0);
        binarySearch(nums, target, 1);
        
        return new int[]{ans_left, ans_right};
        
    }

    public void binarySearch(int[] nums, int target, int mode){
        int left=0, right=nums.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                if(mode == 0){
                    ans_left = mid;
                    right = mid-1;  // 【】
                }
                else{
                    ans_right = mid;
                    left = mid+1;   // 【】
                }   
            }
            else if(nums[mid] < target)
                left = mid+1;
            else 
                right = mid-1;
        }
    }
}
