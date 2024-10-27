class Solution {
    public boolean isValid(String s) {
        List<Character> list = new ArrayList<>();
        int n=s.length();
        char ch, last;
        for(int i=0; i<n; ++i){
            ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                list.add(ch);
            }
            else{
                if(list.isEmpty())
                    return false;
                last = list.get(list.size()-1);
                if(ch==')' && last=='(' || ch==']' && last=='[' || ch=='}' && last=='{')
                    list.remove(list.size()-1);
                else
                    return false;
            }
        }
        if(list.isEmpty())
            return true;
        return false;
    }
}
