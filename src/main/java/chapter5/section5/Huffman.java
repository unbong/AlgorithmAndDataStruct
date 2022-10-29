package chapter5.section5;

import chapter2.PriorityQueue;
import edu.princeton.cs.algs4.BinaryDump;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

public class Huffman {

    private static class Node implements Comparable<Node>{

        private int frequent;  // 频率
        private char character; // 叶子结点保存的单字符
        private Node left, right;


        public Node(char character, int frequent, Node left, Node right){
            this.character = character;
            this.frequent = frequent;
            this.left = left;
            this.right = right;
        }

        /**
         * 判断是否为叶子结点
         * @return
         */
        public boolean isLeaf(){
            return left == null && right == null;
        }

        @Override
        public int compareTo(@NotNull Node that) {
            if(this.frequent > that.frequent) return 1;
            if(this.frequent < that.frequent) return -1;
            return 0;
        }
    }

    private static final int R = 256;

    public static void compress(){


        char[] frequents = new char[R];
        String[] st = new String[R];    // 编译表
        //读取输入
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();
        for(char c : input){
            frequents[c]++;
        }

        //根据频率构造相应的霍夫曼编码树。
        Node root = buildTrie(frequents);
        //构造编译表，将输入中的每个char值和一个比特字符串相关联。
        buildCode(root, st, "");

        //将单词查找树编码为比特字符串并写入输出流。
        writeTrie(root);

        //将单词总数编码为比特字符串并写入输出流。
        BinaryStdOut.write(input.length);

        //使用编译表翻译每个输入字符。
        for(char c : input){
            String binary = st[c];
            for (int i = 0; i < binary.length(); i++) {
                if(binary.charAt(i) == '0')
                    BinaryStdOut.write(false);
                else if(binary.charAt(i) == '1')
                    BinaryStdOut.write(true);
                else   throw new IllegalStateException("Illegal state");
            }
        }
        BinaryStdOut.close();
    }

    /**
     * 将单词查找树编码为比特字符串并写入输出流
     * @param node
     */
    private static void writeTrie(Node node) {
        if(node.isLeaf())
        {
            BinaryStdOut.write(true);
            BinaryStdOut.write(node.character, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(node.left);
        writeTrie(node.right);
    }

    /**
     * 构建编译表
     * @param node
     * @param st
     * @param s
     */
    public static void buildCode(Node node, String[] st, String s){
        if(node.isLeaf())
        {
            st[node.character] = s;
            return;
        }

        buildCode(node.left, st, s+"0");
        buildCode(node.right, st, s+"1");
    }

    private static Node buildTrie(char[] frequents) {

        // 频率小为优先的优先队列
        PriorityQueue<Node> minPQ = new PriorityQueue<>(PriorityQueue.Orientation.MIN);
        //
        for (char i = 0; i < frequents.length; i++) {
            int freq = frequents[i];
            if (freq > 0){
                minPQ.insert(new Node(i, freq, null, null));
            }
        }

        // 从优先队列中取得频率最小的两个结点后构建以此结点为子结点的树，树的父结点（内部结点）的频率为两个子节点之和。
        // 生成完后加到优先队列中
        // 优先队列中至少右两个项目
        while(minPQ.size() > 1){
            Node left = minPQ.pop();
            Node right = minPQ.pop();
            Node parent = new Node('\0', left.frequent+ right.frequent, left, right);
            minPQ.insert(parent);
        }

        return minPQ.pop();
    }


    public static void expand(){
        //读取单词查找树（编码在比特流开头）
        Node root = readTrie();
        StdOut.println("read trie id done.");
        //读取需要解码的字符数量
        int length = BinaryStdIn.readInt();
        
        //使用单词查找树将比特流解码。
        for (int i = 0; i < length; i++) {
            Node x = root;
            while(!x.isLeaf())
            {
                if(BinaryStdIn.readBoolean()){
                    x = x.right;
                }
                else {
                    x = x.left;
                }
            }
            BinaryStdOut.write(x.character, 8);
        }
        BinaryStdOut.close();
    }

    private static Node readTrie() {
        //boolean isLeaf
        boolean isLeaf = BinaryStdIn.readBoolean();
        if(isLeaf){
            return new Node(BinaryStdIn.readChar(),-1 , null, null);
        }
        else{
            return new Node('\0',-1 , readTrie(), readTrie());
        }

    }


    public static void main(String[] args) {
        if      (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}
