package chapter3.section4;

import chapter3.LinearProbingHashTable;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex26_LinearProbingHashSTDelayDeleteTest {

    @Test
    void put() {
    }

    @Test
    void keys() {
    }

    @Test
    void get() {
    }

    @Test
    void delete() {
        Ex26_LinearProbingHashSTDelayDelete<String, Integer> st = new Ex26_LinearProbingHashSTDelayDelete<>(8);
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
}