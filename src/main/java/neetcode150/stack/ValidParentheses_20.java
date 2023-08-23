package neetcode150.stack;

import java.util.Stack;

public class ValidParentheses_20 {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()){
            if(c == '(' || c == '['|| c=='{')
            {
                st.push(c);
            }

            if(c == ')' )
            {
                if(st.isEmpty() || st.pop() != '(')
                    return false;
            }

            if( c == ']')
            {
                if(st.isEmpty() || st.pop() != '[')
                    return  false;
            }

            if(c=='}')
            {
                if(st.isEmpty() || st.pop() != '{')
                    return  false;
            }
        }

        if(!st.isEmpty()) return  false;
        return  true;
    }
}
