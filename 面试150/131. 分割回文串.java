class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> output = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0, 0);
        return ans;
    }

    public void dfs(int start, int curr){
        if(curr == s.length()){
            ans.add(new ArrayList<>(output));
            return ;
        }
        if(curr < s.length()-1){    // 去掉最后一个,因为此时必须判断是否回文了
            dfs(start, curr+1);
        }
        if(isPalindrome(start, curr)){
            output.add(s.substring(start, curr+1));
            dfs(curr+1, curr+1);
            output.remove(output.size()-1);
        }
    }

    public boolean isPalindrome(int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            ++left;
            --right;
        }
        return true;
    }
}
