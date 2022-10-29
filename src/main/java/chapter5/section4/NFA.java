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


/**
 *
 * 正则表达式的模式匹配，非确定有限状态自动机
 * 支持连接操作、或操作'|'、闭包操作'*'、括号'(' ')'、通配符'.'、至少重复1次'+'、重复0或1次'?'、
 * 指定的集合[]、范围集合[A-Z]、补集[^A-Z]、转义符'\'
 * 暂不支持指定重复次数如{3}{1-2}等，
 * 转义符只能转义元字符，不能转义其他特殊字符如"\t" "\n" "\d"等，
 * '*'或'+'操作符后不能接'?'操作符
 * 或操作'|'必须包含在括号内
 *
 * 各种符号对应的操作如下：
 * 连接：每个字母都有一个匹配转换指向下一个字符
 * 单字符闭包：当闭包运算符（*）出现在单个字符后时，在该字符和“*”之间添加两条相互指向的ε-转换
 * 括号、“|”运算、括号外闭包：使用一个栈保存所有的左括号和“|”运算，当遇见右括号时，从栈中弹出一个字符，
 *     判断是否是左括号，如果是“|”运算符，加入一个新列表中，重新从栈中弹出一个字符，直到找到左括号，
 *     从左括号添加到每个“|”运算符后一位的ε-转换，添加每个“|”运算符到右括号的ε-转换，
 *     判断右括号右侧是否为闭包，如果是，在左括号和“*”之间添加两条相互指向的ε-转换
 * 通配符：和普通字符相同，每个字符都有一个匹配转换指向下一个字符，匹配时能够匹配任意字符
 * ============以下内容还未实现===========
 * 至少重复一次：和闭包的区别是只有从“+”字符指向单字符或左括号的ε-转换，没有从单字符或左括号指向“+”字符的ε-转换
 * 重复0或1次：和闭包的区别是只有从单字符或左括号指向“?”字符的ε-转换，没有从“?”字符指向单字符或左括号的ε-转换
 * 指定的集合：对于指定的集合[ABC]D，分别添加从左中括号到A、B、C的ε-转换，再分别添加从A、B、C到右中括号的匹配转换
 *     指定集合的匹配转换不是下一个字符，需要创建一个新数组用于记录匹配转换的状态，
 *     集合中除了取补集的'^'字符、连接字符'-'和转义字符'\'外不能包含其他任何元字符、括号，不能嵌套
 * 范围集合：对于范围集合[A-D]F，分别添加从左中括号到A、-、D的ε-转换，再分别添加从A、-、D到右中括号的匹配转换，
 *     匹配字符串时，如果待匹配字符为'-'，读取左右两侧字符判断是否匹配
 * 补集：对于指定集合[^AB-E]F，添加从左中括号到'^'字符的ε-转换，再添加从'^'字符到右中括号的匹配转换，
 *     匹配字符串时，如果匹配到'^'字符，判断当前字符是否在后面的集合中，如果在则不匹配，否则匹配
 *     对于集合，还需要考虑闭包运算符，因为集合不能嵌套，所以可以将左中括号同样加入栈中，遇见右中括号时弹出
 * 转义序列：对于模式"A\.B"来说，添加一个从'A'到'\'的匹配转换，从'\'到'B'的匹配转换，同时需要考虑B位置为闭包或其他重复次数的情况
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
