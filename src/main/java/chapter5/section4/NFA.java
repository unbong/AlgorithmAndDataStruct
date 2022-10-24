package chapter5.section4;


import chapter1.section3.Queue;
import chapter1.section3.Stack;
import chapter4.DepthFirstDirectedPaths;
import chapter4.Digraph;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * 正则表达式
 */
public class NFA {

    private char[] regularExpression; // 匹配转换
    private Digraph digraph  ;        // epsilon转换
    private int M  ;                  // 状态数量

    /**
     * 构建NFA
     * @param regexp
     */
    public NFA(String regexp){

        M = regexp.length();
        regularExpression = regexp.toCharArray();
        Stack<Integer> stack = new Stack<>();
        digraph = new Digraph(M+1);     // M+1是因为，索引为M时且字符串扫描完毕时表示匹配成功。 为了能够到达索引为M的位置。

        for (int i = 0; i < M; i++) {
            int lp = i;
            if(regularExpression[i] == '(' ||  regularExpression[i] == '|') stack.push(i);
            else if(regularExpression[i] == ')')
            {
                int operation = stack.pop();
                // 或运算， 建立两个epsilon连接， 1 左括号到｜ 右边的第一个字符，2 ｜ （竖线）到右括号
                if(regularExpression[operation] == '|')
                {
                    List<Integer> leftIndecies = new ArrayList<>();
                    leftIndecies.add(operation);

                    // 多想"或"运算对应  例如(.*AB((C|D|E)F)*G)
                    while(regularExpression[stack.peek()] != '(')
                    {
                        leftIndecies.add(stack.pop());
                    }

                    lp = stack.pop();
                    for(Integer n: leftIndecies){
                        digraph.addEdge(lp, n+1);
                        digraph.addEdge(n, i);
                    }
                }
                else lp = operation;   // 保存左括号的位置
            }

            // 闭包运算符，当*的前一个字符为但字符时与但字符两个建立epsilon连接
            // 当*前的一个字符为右括号 "（" 时，连接与右括号与*的两个epsilon连接
            if(i < M-1 && regularExpression[i+1] == '*')
            {
                digraph.addEdge(lp, i+1);
                digraph.addEdge(i+1, lp);
            }

            if(regularExpression[i] == '(' ||regularExpression[i] == '*' ||regularExpression[i] == ')' )
            {
                digraph.addEdge(i, i+1);
            }
        }
        if (stack.size() != 0)
            throw new IllegalArgumentException("Invalid regular expression");

    }

    /**
     * 识别正则表达式是否匹配
     * @param txt
     * @return
     */
    public boolean recognizes(String txt){

        int N = txt.length();
        Queue<Integer> queue = new Queue<>();   // epsilon匹配集合
        DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(digraph, 0); // 起始状态搜集epsilon匹配的状态集合
        for (int i = 0; i < digraph.vertex(); i++) {
            if(dfs.marked(i)) queue.enqueue(i);
        }

        for (int i = 0; i < N; i++) {
            char currentChar = txt.charAt(i);
            if(currentChar == '*' || currentChar == '(' || currentChar == '|' || currentChar == ')')
                throw new IllegalArgumentException("text contains the matchcharacter " + txt.charAt(i) );

            Queue<Integer> match = new Queue<>(); // 匹配转换了的字符索引集
            // 找到匹配转换的字符索引集
            for(Integer regIndex: queue){
                if(regIndex == M) continue;
                if(regularExpression[regIndex] == currentChar || regularExpression[regIndex] == '.')
                {
                    match.enqueue(regIndex+1);
                }
            }

            queue = new Queue<>();
            dfs = new DepthFirstDirectedPaths(digraph, match);

            // 根据匹配转换得到的索引集，再次进行epsilon匹配
            for (int j = 0; j < digraph.vertex(); j++) {
                if(dfs.marked(j)) queue.enqueue(j);
            }

            if(queue.getSize() == 0 ) return false;
        }

        for(int v : queue)
            if(v == M) return true;

        return false;
    }

    public static void main(String[] args) {

        String regexp = "((A*B|AC)D)";





        regexp ="((((A|B)*|CD*|EFG)*)*)";
        NFA nfa = new NFA(regexp);
        StdOut.println("exp true,  recognise: " + nfa.recognizes("AEFG"));

        StdOut.println("exp false,  recognise: " + nfa.recognizes("AAABCG"));


        regexp ="(A.*)";
        NFA n1 = new NFA(regexp);
        StdOut.println("exp true,  recognise: " + n1.recognizes("AEFG"));

        StdOut.println("exp false,  recognise: " + n1.recognizes("BAABC"));


    }
}
