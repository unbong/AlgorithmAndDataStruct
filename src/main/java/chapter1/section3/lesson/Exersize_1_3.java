package chapter1.section3.lesson;

import chapter1.section3.Stack;

public class Exersize_1_3 {



    /**
     * 10 将中值表达式转换为后置表达式
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


    public int evalueate(String exp)
    {

        Stack<String> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        int res;
        for (int i = 0; i < exp.length(); i++){

            String c = exp.(i);

            if(c.equals("("))
            {
                // do nothing
            }
            else if(c.equals("+" )||
                    c.equals("-" )||
                    c.equals("/")||
                    c.equals("*") )
            {
                operator.push(c);
            }
            else if(c.equals(")"))
            {

                int num1 = operand.pop();
                int num2 = operand.pop();
                String oper = operator.pop();
                if(c.equals("+" ))
                {
                    res = num1+ num2;
                }
                else if(c.equals("-"))
                {
                    res = num2-num1;
                }
                else if(c.equals("*"))
                {
                    res = num2*num1;
                }
                else if(c.equals("/"))
                {
                    res = num2/num1;
                }

            }
            else
            {
                operand.push();
            }

        }
    }

    public static void main(String[] args){

        Exersize_1_3 exp10 = new Exersize_1_3();
        String post = exp10.InfixtoPostfix("((1+2)*(3-4)*(5-6))");
        System.out.println(post);


    }
}
