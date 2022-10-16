package chapter5.section2;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TernarySearchTrieTest {

    @Test
    void put() {
        TernarySearchTrie<Integer> st = new TernarySearchTrie<>();

        st.put("she",1);
        st.put("sells",2);
        st.put("sea",3);
        st.put("shells",4);
        st.put("by",5);
        st.put("the",6);
        st.put("sea",7);
        st.put("shore",8);

        assertEquals(1, st.get("she"));
        assertEquals(null, st.get("aa"));
        assertEquals(7, st.get("sea"));

        st.put("shore",null);

        assertEquals(null, st.get("shore"));

    }

    @Test
    void contains() {

        TernarySearchTrie<Integer> st = new TernarySearchTrie<>();
        st.put("she",1);
        st.put("sells",2);
        st.put("sea",3);
        st.put("shells",4);
        st.put("by",5);
        st.put("the",6);
        st.put("sea",7);
        st.put("shore",8);

        assertEquals(true, st.contains("she"));
        assertEquals(false, st.contains("ss"));
    }

    @Test
    void get() {

        TernarySearchTrie<Integer> st = new TernarySearchTrie<>();
        st.put("she",1);
        st.put("sells",2);
        st.put("sea",3);
        st.put("shells",4);
        st.put("by",5);
        st.put("the",6);
        st.put("sea",7);
        st.put("shore",8);

        assertEquals(null, st.get(" "));

        assertEquals(null, st.get("shee"));

        assertEquals(null, st.get("shes"));
        assertEquals(1, st.get("she"));
        assertEquals(7, st.get("sea"));
    }

    @Test
    void delete() {
    }

    @Test
    void size() {
        TernarySearchTrie<Integer> st = new TernarySearchTrie<>();
        st.put("she",1);
        st.put("sells",2);
        st.put("sea",3);
        st.put("shells",4);
        st.put("by",5);
        st.put("the",6);
        st.put("sea",7);
        st.put("shore",8);

        assertEquals(7, st.size());
    }

    @Test
    void isEmpty() {

        TernarySearchTrie<Integer> st = new TernarySearchTrie<>();
        assertEquals(true, st.isEmpty());
        st.put("she",1);
        st.put("sells",2);
        st.put("sea",3);
        st.put("shells",4);
        st.put("by",5);
        st.put("the",6);
        st.put("sea",7);
        st.put("shore",8);
        assertEquals(false, st.isEmpty());
    }

    @Test
    void longestPrefixOf() {

        TernarySearchTrie<Integer> st = new TernarySearchTrie<>();

        st.put("she",1);
        st.put("sells",2);
        st.put("sea",3);
        st.put("shells",4);
        st.put("by",5);
        st.put("the",6);
        st.put("sea",7);
        st.put("shore",8);

        assertEquals("she", st.longestPrefixOf("shell"));
        assertEquals("shells", st.longestPrefixOf("shells"));
    }

    @Test
    void keysWithPrefix() {

        TernarySearchTrie<Integer> st = new TernarySearchTrie<>();

        st.put("she",1);
        st.put("sells",2);
        st.put("sea",3);
        st.put("shells",4);
        st.put("by",5);
        st.put("the",6);
        st.put("sea",7);
        st.put("shore",8);

        StdOut.println("prefix a");
        if(st.keysWithPrefix("a") != null){
            for(String item : st.keysWithPrefix("a")){
                StdOut.print(item+", ");
            }
        }


        StdOut.println("prefix se");
        if(st.keysWithPrefix("se") != null){
            for(String item : st.keysWithPrefix("se")){
                StdOut.print(item+", ");
            }
        }

        StdOut.println("prefix sh");
        if(st.keysWithPrefix("sh") != null){
            for(String item : st.keysWithPrefix("sh")){
                StdOut.print(item+", ");
            }
        }
    }

    @Test
    void keysThatMatch() {

        TernarySearchTrie<Integer> st = new TernarySearchTrie<>();

        st.put("she",1);
        st.put("sells",2);
        st.put("sea",3);
        st.put("shells",4);
        st.put("by",5);
        st.put("the",6);
        st.put("sea",7);
        st.put("shore",8);

        StdOut.println("match .th");
        for (String item : st.keysThatMatch(".th"))
        {
            StdOut.print(item+", ");
        }

        StdOut.println("match .he");
        for (String item : st.keysThatMatch(".he"))
        {
            StdOut.print(item+", ");
        }
        StdOut.println();
        StdOut.println("match s..");
        for (String item : st.keysThatMatch("s.."))
        {
            StdOut.print(item+", ");
        }
    }

    @Test
    void keys() {
        TernarySearchTrie<Integer> st = new TernarySearchTrie<>();

        st.put("she",1);
        st.put("sells",2);
        st.put("sea",3);
        st.put("shells",4);
        st.put("by",5);
        st.put("the",6);
        st.put("sea",7);
        st.put("shore",8);


        for(String item: st.keys()){
            StdOut.println(item);
        }
    }
}