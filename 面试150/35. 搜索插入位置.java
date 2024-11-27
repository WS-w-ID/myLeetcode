class Solution {
    public int searchInsert(int[] nums, int target) {
        /**对于 left, mid, right
            1. 若 nums[mid] > target: 那么right就会-1使得left=right，并且nums[right]<target，这里的结果是right+1。
                那么我们可以改变循环条件为left<=right，这样就再判断一次，使得left+1，那么就得到结果left+1。
            2. 若 nums[mid] < target: 那left就会+1使得left=right，并且nums[left]>target，那么这里已经可以得到结果就是left。
                但是为了兼容情况1，再判断一次，也是right-1，不影响left。
         */
        // 标准的二分查找模板
        int left=0, right=nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }
}
