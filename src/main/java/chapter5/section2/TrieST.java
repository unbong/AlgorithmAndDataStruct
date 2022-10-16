package chapter5.section2;

import chapter1.section3.Queue;

public class TrieST <Value>{

    private Node root;

    private static  int R = 256;
    private  int size;

    private static   class Node{
        private Object value;
        private Node[] next = new Node[R];
    }


    public int size(){
        return size;
    }


    /**
     * 插入键值对
     * @param key
     * @param value
     */
    public void put(String key, Value value){
        if(key == null ) throw new IllegalArgumentException("key argument of put is null.");
        if(value == null) delete(key);

        root = put(root, key, value, 0 );

    }


    /**
     * 插入键值对
     * @param node
     * @param key
     * @param value
     * @param d
     * @return
     */
    private Node put(Node node, String key, Value value, int d)
    {
        // 新插入的键在字符表中不存在时，新键字符结点
        if(node == null) node = new Node();
        // 新插入的键在字符表中不存在值时，写入值。
        if(d == key.length()){
            if(node.value == null) size++;
            node.value = value;
            return node;
        }
        // 递归找到键写入值的位置
        char c = key.charAt(d);
        node.next[c] = put(node.next[c], key, value , d+1);
        return node;
    }

    /**
     * 删除键
     * @param key
     */
    public void delete(String key) {

        if(key == null) throw new IllegalArgumentException("key argument of delete is null.");

        root = delete(root, key, 0);
    }

    /**
     *
     * @param node
     * @param key
     * @param d
     * @return
     */
    private Node delete(Node node, String key, int d) {

        // 查找字符串对应的字符不存在
        if (node == null) return null;

        // 查找字符串的最后一个键设为空，如果最后一个键的值不为空时，说明在字符标中存在该键，size要减少。
        if(d == key.length())
        {
            if(node.value != null){
                size--;
            }
            node.value = null;
        }
        //  递归调用直到到达最后一个字符为止
        else{
            char c = key.charAt(d);
            node.next[c] = delete(node.next[c], key, d+1);
        }

        // 字符串的路径当中某一个字符的值非空时，返回该字符结点，不删除
        if(node.value != null) return node;

        // 字符串的路径当中某一个键有其他的子链接时返回该结点，不删除
        for (int i = 0; i < R; i++) {
            if(node.next[i] != null) return node;
        }

        return null;

    }


    /**
     * 取得键
     * @param key
     * @return
     */
    public Value get(String key){
        Node node = get(root, key , 0);
        if(node == null) return null;
        return (Value) node.value;
    }

    private Node get(Node node, String key, int d){

        // 当查询键的最后一个字符对应的结点为空，
        if(node == null) return null;

        //
        if( d == key.length() ) return node;

        char c = key.charAt(d);
        return get(node.next[c], key, d+1);
    }


    /**
     * 表中是否保存着key的值
     * @param key
     * @return
     */
    public boolean contains(String key){
        if(key == null) throw new IllegalArgumentException("argument of key is null.");
        return get(root, key, 0) != null;
    }


    /**
     * 字符表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 符号表中的所有键
     * @return
     */
    public Iterable<String> keys(){
        return keysWithPrefix("");
    }

    /**
     * 搜集包含前缀的字符串
     * @param prefix
     * @return
     */
    public Iterable<String> keysWithPrefix(String prefix)
    {
        if(prefix == null) throw new IllegalArgumentException("keysWithPrefix argument is null.");
        Queue<String> queue = new Queue<>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), queue);
        return queue;
    }

    /**
     * 搜集包含所有前缀字符串的在字符表中存在的键
     * @param node   前缀字符串追后字符所在的顶点-开始搜集的顶点
     * @param prefix 前缀
     * @param queue   返回值
     */
    private void collect(Node node, StringBuilder prefix,  Queue<String> queue)
    {
        // 字符不再字符表时退出
        if (node == null ) return;

        // 在字符标中存在prefix前缀的字符串是 写入到队列当中
        if(node.value != null){
            queue.enqueue(prefix.toString());
        }

        // 遍历所有子节点
        for (char i = 0; i < R; i++) {
            prefix.append(i);
            collect(node.next[i], prefix,  queue);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    /**
     * prefix前缀中最长的键
     * @param prefix
     * @return
     */
    public String longestPrefixOf(String prefix){
        if(prefix == null) throw new IllegalArgumentException("longestPrefixOf argument is null.");

        int length = longestPrefixOf(root, prefix, -1, 0);
        if(length == -1) return null;
        return prefix.substring(0,length);
    }

    /**
     *
     * @param node
     * @param prefix
     * @param d
     * @return
     */
    private int longestPrefixOf(Node node, String prefix, int length, int d)
    {
        // 前缀长度大于字符表查询路径字符串的长度
        if (node == null) return length;

        // 沿着前缀的路径上的字符结点有值时，更新长度的变量，
        if(node.value != null) length = d;

        // 前缀长度小于字符表查询路径字符串的长度时 返回长度
        if(d == prefix.length()) return length;

        char c = prefix.charAt(d);
        return longestPrefixOf(node.next[c], prefix, length, d+1);
    }

    /**
     * 所有和s匹配的键 .能匹配任意字符
     * @param pattern
     * @return
     */
    public Iterable<String> keysThatMatch(String pattern){
        if (pattern == null) throw new IllegalArgumentException("keysThatMatch argument is null");

        Queue<String> queue = new Queue<>();
        collect(root, new StringBuilder() , pattern, queue);
        return queue;
    }


    private void collect(Node node, StringBuilder pre , String pattern , Queue<String> queue){

        // pattern长度大于字符标中查询路径上的长度
        if(node == null) return ;
        // 当前前缀的长度
        int d = pre.length();
        // 到了最后一个字节，且字符结点的值非空
        if(d == pattern.length() && node.value != null) queue.enqueue(pre.toString());
        // 到了最后一个结点 字符结点值为空则返回
        if(d == pattern.length())  return;

        char c = pattern.charAt(d);

        // 如果有. 则遍历每一个字符。
        if(c == '.')
        {
            for (char i = 0; i < R; i++) {
                pre.append(i);
                collect(node.next[i], pre, pattern, queue);
                pre.deleteCharAt(pre.length()-1);
            }
        }
        else
        {
            pre.append(c);
            collect(node.next[c], pre, pattern, queue);
            pre.deleteCharAt(pre.length()-1);
        }


    }
}
