package neetcode150.tries;

public class Trie {

    class TrieNode {
        char letter;
        TrieNode[] next;
        boolean isEnd;
        public TrieNode(char letter){
            this.letter = letter;
            this.next = new TrieNode[26];
            this.isEnd = false;
        }
    }
    private TrieNode root ;

    public Trie() {
         root = new TrieNode('/');
    }

    /**
     * Trie树的节点中包括一个字符和26个节点组成的数组和标识最后一个字符的标志符
     *  * 创建一个搜索树时
     * @param word
     */
    public void insert(String word) {

        TrieNode p = this.root ;
        for(Character c : word.toCharArray()){

            if(p.next[c-'a'] == null)
            {
                TrieNode node  = new TrieNode(c);
                p.next[c-'a'] = node;
            }
            p = p.next[c-'a'] ;
        }
        p.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode p = this.root;
        boolean isEnd = false;
        for(Character c: word.toCharArray()){
            TrieNode node = p.next[c-'a'];
            if(node == null){
                return false;
            }
            isEnd = node.isEnd;
            p = node;
        }
        return isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = this.root;
        int i = 0;
        int len = prefix.length();
        for(;i < len;i++){
            Character c = prefix.charAt(i);
            TrieNode node = p.next[c-'a'];
            if(node == null) return false;
            p = node;
        }

        return i == len;
    }
}
