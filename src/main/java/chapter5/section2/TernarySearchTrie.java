package chapter5.section2;

import chapter1.section3.Queue;

/**
 * 单词查找树
 * @param <Value>
 */
public class TernarySearchTrie<Value> {
    private int size;
    private Node root;

    private class Node{
        private char c;
        private Value value;

        private Node left, mid , right;

    }

    /**
     * 想表中插入键值对
     * @param key
     * @param val
     */
    public void put(String key , Value val){
        if(key == null) throw new IllegalArgumentException("argument of put key is null.");

        if(!contains(key)) size++;
        else if(val == null) size--;

        root = put(root, key, val, 0);
    }



    private Node put(Node node, String key, Value val, int d) {
        char c = key.charAt(d);

        // 增加一个字符结点
        if(node == null){
            node = new Node();
            node.c = c;
        }

        // 当字符小于字符表的字符时， 到左子节点
        if(c < node.c ) node.left = put(node.left, key, val, d);
        // 当字符大于字符表的字符时， 到右子节点
        else if(c > node.c ) node.right = put(node.right, key, val, d);
        // 当字符等于字符表的字符时，且没有达到插入键字符串的最后一个字符时， 到中子节点
        else if(d < key.length()-1) node.mid = put(node.mid, key, val, d+1);
        else node.value = val;
        return node;
    }

    /**
     * 表中是否保存着key的值
     * @param key
     * @return
     */
    public boolean contains(String key) {
        if(key == null) throw new IllegalArgumentException("argument contains is null.");
        return get(key)  != null;
    }

    /**
     * 键key所对应的值
     * @param key
     * @return
     */
    public Value get(String key){
        if(key == null) throw new IllegalArgumentException("argument get is null.");
        if(key.length() == 0) throw new IllegalArgumentException("key must have length >= 1.");
        Node node = get(root, key , 0);
        if(node == null) return null;

        return  node.value;
    }

    private Node get(Node node, String key, int d){

        // key 大于 字符表中的查找路径上的字符串长度
        if(node == null) return null;
        if(key.length() == 0) throw new IllegalArgumentException("key must have length >= 1.");
        char c = key.charAt(d);
        if( c < node.c ) return get(node.left, key, d);
        else if(c > node.c ) return get(node.right, key, d);
        else if(d < key.length()-1) return get(node.mid, key, d+1);

        return node;

    }


    /**
     * 删除键key todo 没做出来
     * @param key
     */
    public void delete(String key) {

        if(key == null)  throw new IllegalArgumentException("argument delete is null.");

        root = delete(root, key, 0);
    }

    private Node delete(Node node, String key, int d) {
        if(node == null) return null;

        if(d == key.length()){
            node.value = null;

        }
        return node;
    }

    /**
     * 键值对数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * prefix 的前缀中最长的键
     * @param prefix
     * @return
     */
    public String longestPrefixOf(String prefix){
        if (prefix == null ) throw new IllegalArgumentException("longestPrefix argument is null.");
        if(prefix.length() == 0) return  null;
        int length = longestPrefixOf(root, prefix ,0,-1 );
        if(length == -1 ) return null;
        return prefix.substring(0, length+1);
    }

    /**
     *
     * @param node
     * @param prefix
     * @param d         递归的深度，与字符串的长度也有关，在这里返回的值为深度，因此在外部截取长度时需要+1 处理因为深度的长度之间的关系为差1
     * @param length
     * @return
     */
    private int longestPrefixOf(Node node, String prefix, int d, int length) {

        //  当到达空结点时返回长度
        if (node == null) return length;
        // 当prefix前缀的最后一个字节时，返回最长长度
        if( d == prefix.length() ) return length;
        // 当字符结点的值不为空时，更新最长长度变量
        if(node.value != null) length = d;

        char c = prefix.charAt(d);
        if(c < node.c ) return longestPrefixOf(node.left, prefix, d, length);
        else if(c > node.c ) return longestPrefixOf(node.right, prefix, d, length);
        else return longestPrefixOf(node.mid, prefix, d+1, length);
    }


    /**
     * 所有以prefix为前缀的键
     * @param prefix
     * @return
     */
    public Iterable<String> keysWithPrefix(String prefix){
        if (prefix == null ) throw new IllegalArgumentException("keysWithPrefix argument is null.");

        Queue<String> queue = new Queue<String>();
        Node node = get(root, prefix, 0);
        if(node == null) return null;
        if(node.value != null) queue.enqueue(prefix);

        collect(node.mid, new StringBuilder(prefix), queue);
        return queue;
    }

    /**
     * 搜集prefix 前缀开头的所有键
     * @param node
     * @param key
     * @param queue
     */
    private void collect(Node node, StringBuilder key , Queue<String> queue){
        if (node == null) return ;

        if(node.value != null )
        {
            key.append(node.c);
            queue.enqueue(key.toString());
            key.deleteCharAt(key.length()-1);
        }

        collect(node.left, key, queue);
        collect(node.right, key, queue);
        key.append(node.c);
        collect(node.mid, key, queue);
        key.deleteCharAt(key.length()-1);
    }

    /**
     *
     * @param pattern
     * @return
     */
    public Iterable<String> keysThatMatch(String pattern){
        if (pattern == null ) throw new IllegalArgumentException("keysThatMatch argument is null.");

        Queue<String> queue = new Queue<>();
        collect(root, new StringBuilder(), pattern, queue, 0);

        return queue;
    }

    /**
     * 搜集符合pattern的键
     * @param node
     * @param key
     * @param pattern
     * @param queue
     */
    private void collect(Node node, StringBuilder key, String pattern, Queue<String> queue , int d) {

        if(node == null) return ;


        if(d == pattern.length()-1 && node.value != null) queue.enqueue(key.toString()+ node.c);
        if(d == pattern.length()) return ;

        char c = pattern.charAt(d);
        if(c == '.')
        {
            collect(node.left, key, pattern, queue,d);
            collect(node.right, key, pattern, queue,d);
            key.append(node.c);
            collect(node.mid, key, pattern, queue,d+1);
            key.deleteCharAt(key.length()-1);
        }
        else{
            if(c < node.c) collect(node.left, key, pattern, queue,d);
            else if (c > node.c) collect(node.right,key, pattern, queue,d);
            else {
                key.append(node.c);
                collect(node.mid, key, pattern, queue,d+1);
                key.deleteCharAt(key.length()-1);
            }
        }

    }

    /**
     *
     * @return
     */
    public Iterable<String> keys(){
        Queue<String> queue = new Queue<>();
        collect(root,new StringBuilder(), queue);
        return queue;
    }

}
