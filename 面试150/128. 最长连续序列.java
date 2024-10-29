class Solution {
    /**去重，再判断每个数是否为序列开头，是的话就统计此序列长度，不是则跳过 */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        int ans = 0, currLen = 0;
        for(int num : nums){
            if(!set.contains(num-1)){    // num是序列开头
                currLen = 1;
                while(set.contains(++num)){
                    ++currLen;
                }
                ans = Math.max(ans, currLen);
            }
        }
        return ans;
    }
}
