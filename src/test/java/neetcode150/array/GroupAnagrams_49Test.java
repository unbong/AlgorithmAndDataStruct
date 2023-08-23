package neetcode150.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagrams_49Test {

    @Test
    void groupAnagrams() {

        GroupAnagrams_49 g = new GroupAnagrams_49();
        String[] strs ={"eat","tea","tan","ate","nat","bat"};
        List<List<String>>res = g.groupAnagrams(strs);

    }
}