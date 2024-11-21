class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)
            return ans;
        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        
        backtrace(ans, phoneMap, digits, 0, new StringBuffer());

        return ans;
    }

    public void backtrace(List<String> ans, Map<Character, String> phoneMap, String digits, int index, StringBuffer output){
        if(index == digits.length()){   // 遍历到最后一个字符集
            ans.add(output.toString());
            return ;
        }
        String letters = phoneMap.get(digits.charAt(index));    // 当前对应的字符集
        int n = letters.length();
        for(int i=0; i<n; ++i){ // 遍历当前对应的字符集
            output.append(letters.charAt(i));
            backtrace(ans, phoneMap, digits, index+1, output);  // dfs
            output.deleteCharAt(index); // 当前字符的位置是index
        }
    }
}
