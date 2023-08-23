package neetcode150.stack;

import java.util.*;

public class GenerateParentheses_22 {

    Stack<String> stack = new Stack<>();
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        backtrack(n, 0,0);
        return list;
    }

    private  void  backtrack(int n, int open, int close ){

        if(n == open && n == close)
        {
            StringBuilder sb = new StringBuilder();
            for (String s : stack)
            {
                sb.append(s);
            }
            list.add(sb.toString());
        }

        if(open < n){
            stack.push("(");
            backtrack(n, open+1, close);
            stack.pop();
        }

        if(close < open){
            stack.push(")");
            backtrack(n, open, close+1);
            stack.pop();
        }

    }
}
