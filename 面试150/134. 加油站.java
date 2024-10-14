class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans=0, minValue=Integer.MAX_VALUE,n=gas.length;
        int sum=0;
        for(int i=0; i<n; ++i){
            sum += gas[i] - cost[i];
            if(sum < minValue){
                minValue = sum;
                ans = i;
            }
        }
        return sum<0 ? -1: (ans+1)%n;
    }
}
