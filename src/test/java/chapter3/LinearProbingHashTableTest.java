package chapter3;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearProbingHashTableTest {

    @Test
    void size() {

        LinearProbingHashTable<String, Integer> st = new LinearProbingHashTable<>();
        st.put("A",1);
        st.put("C",1);
        st.put("D",1);
        st.put("E",1);
        st.put("F",1);
        st.put("G",1);
        st.put("AA",1);
        st.put("BA",1);

        assertEquals(8, st.size());
    }

    @Test
    void isEmpty() {

        LinearProbingHashTable<String, Integer> st = new LinearProbingHashTable<>();
        assertEquals(true, st.isEmpty());
        st.put("A",1);
        st.put("C",1);
        st.put("D",1);
        st.put("E",1);
        st.put("F",1);
        st.put("G",1);
        st.put("AA",1);
        st.put("BA",1);

        assertEquals(false, st.isEmpty());

    }

    @Test
    void contains() {
        LinearProbingHashTable<String, Integer> st = new LinearProbingHashTable<>();
        st.put("A",1);
        st.put("C",3);
        st.put("D",4);
        st.put("E",1);
        st.put("F",1);
        st.put("G",1);
        st.put("AA",1);
        st.put("BA",1);

        assertEquals(true,st.contains("A"));
        assertEquals(false,st.contains("SC"));

    }

    @Test
    void get() {
        LinearProbingHashTable<String, Integer> st = new LinearProbingHashTable<>();
        st.put("A",1);
        st.put("C",3);
        st.put("D",4);
        st.put("E",5);
        st.put("F",6);
        st.put("G",7);
        st.put("AA",8);
        st.put("BA",9);

        assertEquals(1, st.get("A"));
        assertEquals(8, st.get("AA"));
    }

    @Test
    void put() {
        LinearProbingHashTable<String, Integer> st = new LinearProbingHashTable<>();
        st.put("A",1);
        st.put("C",3);
        st.put("D",4);
        st.put("E",5);
        st.put("F",6);
        st.put("G",7);
        st.put("AA",8);
        st.put("BA",9);

        st.put("A", 12);


        for (String s: st.keys())
        {
            StdOut.print(s +","+ st.get(s) + ", ");
        }


    }

    @Test
    void delete() {
        LinearProbingHashTable<String, Integer> st = new LinearProbingHashTable<>();
        st.put("A",1);
        st.put("C",3);
        st.put("D",4);
        st.put("E",5);
        st.put("F",6);
        st.put("G",7);
        st.put("AA",8);
        st.put("BA",9);

        st.delete("M");
        assertEquals(8, st.size());

        st.delete("A");
        assertEquals(7, st.size());

        st.delete("C");
        st.delete("D");
        st.delete("E");
        st.delete("F");
        st.delete("G");
        st.delete("AA");
        st.delete("BA");
        st.delete("A");

        StdOut.println("");

    }

    @Test
    void resize() {
    }

    @Test
    void keys() {
    }
}