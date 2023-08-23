package neetcode150.tries;


/**
 * 使用trie树的结构，对单词进行存储。
 *  难点在于对.的查询
 *   .对应着任意字符，因此在遇到.时，遍历该层的所有节点，并检查盖层节点的下一个节点与查询字符串的下一个单词
 */
public class WordDictionary {

    class WDNode{
        char letter;
        WDNode[] next;
        boolean isEnd;
        public WDNode(char letter){
            this.letter = letter;
            next = new WDNode[26];
            isEnd = false;
        }
    }

    private  WDNode root;
    public WordDictionary() {
        root = new WDNode('/');
    }

    public void addWord(String word) {

        WDNode p = root;
        for(char c : word.toCharArray()){
            WDNode node = p.next[c-'a'];
            if(node == null){
                p.next[c-'a'] = new WDNode(c);
            }
            p = p.next[c-'a'] ;
        }
        p.isEnd = true;
    }

    private boolean search(int index, String word, WDNode node){

        for(int i = index; i<word.length();i++){
            char letter = word.charAt(i);
            if(letter == '.')
            {
                for (int j = 0; j < 26; j++) {
                    if (node.next[j] == null) continue;
                    boolean res =search (i+1, word, node.next[j]);
                    if (res ) return true;
                }
                return false;
            }
            else{
                if( node == null || node.next[letter-'a'] == null) return false;

                node = node.next[letter-'a'];
            }
        }
        return node.isEnd;
    }

    public boolean search(String word) {

        return search(0, word, this.root);

    }
}
