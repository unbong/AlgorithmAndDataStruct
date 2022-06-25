package chapter1.section3.exersize;

import chapter1.section3.Stack;

public class Exersize_1_3 {



    /**
     * 10 将中值表达式转换为后置表达式
     *  这个不对 没思路
     * @param exp
     * @return
     */
    public String InfixtoPostfix(String exp)
    {
        Stack<String> operator = new Stack<>();
        Stack<String> operand = new Stack<>();

        String postFix = "";
        for (int i = 0; i < exp.length(); i++){

            char c = exp.charAt(i);

            if(c == '(')
            {
                // do nothing
            }
            else if(c == '+' ||
                    c == '-' ||
                    c == '/' ||
                    c == '*')
            {
                operator.push(""+c);
            }
            else if(c == ')')
            {
                String num1 = operand.pop();
                String num2 = operand.pop();
                String oper = operator.pop();
                postFix =  num2 + num1 + oper;
                operand.push(postFix);
            }
            else
            {
                operand.push(""+c);
            }
        }
        return postFix;
    }

    /**
     * 1.3.11
     *  利用后置表达式进行计算
     * @param exp
     * @return
     */
    public int evalueate(String exp)
    {
        Stack<String> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < exp.length(); i++){

            String c = exp.substring(i, i+1);

            if(c.equals("+" ))
            {
                int num1 = operand.pop();
                int num2 = operand.pop();
                res = num1+ num2;
                operand.push(res);
            }
            else if(c.equals("-"))
            {
                int num1 = operand.pop();
                int num2 = operand.pop();
                res = num2-num1;
                operand.push(res);
            }
            else if(c.equals("*"))
            {
                int num1 = operand.pop();
                int num2 = operand.pop();
                res = num2*num1;
                operand.push(res);
            }
            else if(c.equals("/"))
            {
                int num1 = operand.pop();
                int num2 = operand.pop();
                res = num2/num1;
                operand.push(res);
            }
            else
            {
                operand.push(Integer.valueOf(c));
            }

        }
        return res;
    }

    public static void main(String[] args){

        Exersize_1_3 exp10 = new Exersize_1_3();
        String post = exp10.InfixtoPostfix("((1+2)*(3-4)*(5-6))");
        System.out.println(post);


    }
}
