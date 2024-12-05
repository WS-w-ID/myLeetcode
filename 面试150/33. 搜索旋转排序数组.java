class Solution {
    public int search(int[] nums, int target) {
        /**小的一端最大的一个数都要比大的一端最小的一个数小 */
        int left=0, right=nums.length-1, n=nums.length;
        if(n <= 1)
            return (nums[0]==target) ? 0 : -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] >= nums[0]){   // mid在大的那边
                if(target >= nums[0] && nums[mid] > target){ // target在左边有序侧
                    right = mid-1;
                }
                else
                    left = mid+1;
            }
            else{   // mid在小的那边
                if(target > nums[mid] && target <= nums[n-1]){ // target在右边有序侧
                    left = mid+1;
                }
                else
                    right = mid-1;
            }
        }
        return -1;
    }
}
