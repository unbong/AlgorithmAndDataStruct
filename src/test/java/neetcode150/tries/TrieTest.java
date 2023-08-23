package neetcode150.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void insert() {
        Trie t = new Trie();
        t.insert("apple");
        assertEquals(false,t.search("app"));
        assertEquals(true,t.search("apple"));
        assertEquals(true, t.startsWith("app"));
        t.insert("app");
        assertEquals(true,t.search("app"));


    }


    @Test
    void search() {
    }

    @Test
    void startsWith() {
    }
}