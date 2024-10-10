class Solution {
    public int majorityElement(int[] nums) {
        /**HashMap */
        // HashMap<Integer, Integer> map = new HashMap<>();

        // int n=nums.length, ansIndex=0, maxCount=1;
        // for(int i=0; i<n; ++i){
        //     if(!map.containsKey(nums[i])){
        //         map.put(nums[i],1);
        //     }
        //     else{
        //         int newCount = map.get(nums[i])+1;
        //         map.put(nums[i], newCount);
        //         if(newCount > maxCount){
        //             maxCount = newCount;
        //             ansIndex = i;
        //         }
        //     }
        // }
        // return nums[ansIndex];

        /**Vote */
        int count=0;
        Integer candidate=null;
        for(int num : nums){
            if(count == 0)
                candidate = num;
            if(num == candidate)
                ++count;
            else if(num != candidate)
                --count;
        }
        return candidate;
    }
}
