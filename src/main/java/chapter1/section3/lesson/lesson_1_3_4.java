package chapter1.section3.lesson;

import chapter1.section3.Stack;

import java.util.Scanner;

public class lesson_1_3_4 {

    private Stack<Character> pattrenStack = new Stack<>();
    public boolean checkPattern(String s)
    {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
            {
                pattrenStack.push(c);
            }
            else if(c == ')' )
            {
                Character rc = pattrenStack.pop();
                if (rc != '(') {
                    throw new RuntimeException("not match data index:" + i);
                }
            }
            else if( c == ']' )
            {
                Character rc = pattrenStack.pop();
                if (rc != '[') {
                    throw new RuntimeException("not match data index:" + i);
                }
            }
            else if( c == '}')
            {
                Character rc = pattrenStack.pop();
                if (rc != '{') {
                    throw new RuntimeException("not match data index:" + i);
                }
            }
        }

        if(pattrenStack.isEmpty() == false)
        {
            throw new RuntimeException("not match data index:");
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input>");
        String input = scanner.nextLine();

        lesson_1_3_4 patternCheck = new lesson_1_3_4();
        boolean check = patternCheck.checkPattern(input);
        System.out.println("result:" + check);
        scanner.close();
    }

}
