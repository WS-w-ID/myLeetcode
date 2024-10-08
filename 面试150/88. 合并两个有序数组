class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**避免覆盖，于是从大到小从后往前排序
         */
        int ind1=m-1, ind2=n-1, ind=m+n-1;
        while(ind1>=0 && ind2>=0){
            if(nums1[ind1] >= nums2[ind2]){
                nums1[ind--] = nums1[ind1--];
            }
            else{
                nums1[ind--] = nums2[ind2--];
            }
        }
        while(ind1 >= 0){
            nums1[ind--] = nums1[ind1--];
        }
        while(ind2 >= 0){
            nums1[ind--] = nums2[ind2--];
        }
    }
}
