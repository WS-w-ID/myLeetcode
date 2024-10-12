class Solution {
    public int jump(int[] nums) {
        /**在能到达的下标范围内遍历维护一个下次到达的最远下标，遍历结束后就更新范围 */
        int n=nums.length, step=0;
        int boundaryIndex = 0, nextBoundaryIndex = 0;
        if(n == 1)
            return 0;
        for(int i=0; i<n; ++i){
            nextBoundaryIndex = Math.max(nextBoundaryIndex, i+nums[i]);
            if(i == boundaryIndex){
                boundaryIndex = nextBoundaryIndex;
                ++step;
                if(boundaryIndex >= n-1)    //提前跳出,剩余的就不用再遍历了 eg. [1 2 1000 ... 1]
                    return step;
            }
        }
        return step;
    }
}
