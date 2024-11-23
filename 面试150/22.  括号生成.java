class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        backtrace(ans, output, 0, 0, n);
         
        return ans;
        
    }


    /**左括号和右括号应该分别有n个
     */
    public void backtrace(List<String> ans, StringBuilder output, int open, int close, int n){
        if(output.length() == 2*n){
            ans.add(output.toString());
            return ;
        }
       if(open < n){   // 左括号还没满，可以尝试添加
            output.append('(');
            backtrace(ans, output, open+1, close, n);
            output.deleteCharAt(output.length()-1);
        }
        if(close < open){   // 右括号的数量不能比左括号多，即不能先于左括号添加
            output.append(')');
            backtrace(ans, output, open, close+1, n);
            output.deleteCharAt(output.length()-1);
        }
    }
}
