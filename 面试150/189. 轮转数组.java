class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        /** k为需要放到前面的尾部元素的个数,所以先翻转整个数组 O(2n) O(1) */
        // reverse(nums, 0, nums.length-1);
        // reverse(nums, 0, k-1);
        // reverse(nums, k, nums.length-1);

        /** 所以前面的元素为nums.length-k个,也可以这样写 */
        // reverse(nums, 0, nums.length-k-1);
        // reverse(nums, nums.length-k, nums.length-1);
        // reverse(nums, 0, nums.length-1);

        /**环状数组 O(n) O(1) */
        int n=nums.length;
        int count = gcd(k, n);
        for(int start=0; start<count; ++start){
            int currentIndex = start;
            int currentValue = nums[currentIndex];
            do{
                int nextIndex = (currentIndex +k)%n;
                int nextValue = nums[nextIndex];
                
                nums[nextIndex] = currentValue;

                currentIndex = nextIndex;
                currentValue = nextValue;
            }while(currentIndex != start);
        }
    }

    public int gcd(int x, int y){   // 最大公约数
        return y>0 ? gcd(y, x%y) : x;
    }

    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;

            ++left;
            --right;
        } 
    }
}
