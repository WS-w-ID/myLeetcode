class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans=0, n=s.length();
        char pre=s.charAt(0), curr;
        int val, lastVal;
        ans += map.get(pre);
        for(int i=1; i<n; ++i){
            curr = s.charAt(i);
            val = map.get(curr);
            lastVal = map.get(pre);
            ans += val;
            if(val > lastVal)
                ans -= lastVal << 1;
            pre = curr;
        }
        return ans;
    }
}
