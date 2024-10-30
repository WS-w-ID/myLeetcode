class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numStack = new LinkedList<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int second = numStack.pop(), first = numStack.pop();
                if(token.equals("+"))
                    numStack.push(first + second);
                else if(token.equals("-"))
                    numStack.push(first - second);
                else if(token.equals("*"))
                    numStack.push(first * second);
                else if(token.equals("/"))
                    numStack.push(first / second);
            }
            else
                numStack.push(Integer.parseInt(token));
        }
        return numStack.pop();
    }
}
