package neetcode150.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordDictionaryTest {

    @Test
    void addWord() {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        assertEquals(wd.search("pad"),false);
        assertEquals(true, wd.search("bad"));
        assertEquals(true, wd.search(".ad"));
        assertEquals(true, wd.search("b.."));

    }

    @Test
    void search() {
    }
}