class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i=0; i<n; ++i){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){    // 循环判断且'<'代表严格递减
                int prevIndex = stack.poll();
                ans[prevIndex] = i-prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
