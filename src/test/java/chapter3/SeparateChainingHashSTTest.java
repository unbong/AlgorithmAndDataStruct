package chapter3;

import org.junit.jupiter.api.Test;
import utils.IntRandom;

import static org.junit.jupiter.api.Assertions.*;

class SeparateChainingHashSTTest {

    @Test
    void put() {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>(4,4);
        st.put("A",1);
        st.put("B",7);
        st.put("C",3);
        st.put("D",4);
        st.put("E",5);
        st.put("F",6);
        st.put("G",7);
        st.put("H",7);
        st.put("I",7);
        st.put("J",7);
        st.put("K",7);
        st.put("L",7);
        st.put("M",7);
        st.put("N",7);
        st.put("O",7);
        st.put("P",7);
        st.put("AA",8);
        st.put("BA",9);

        st.delete("A");
        st.delete("B");
        st.delete("C");
        st.delete("D");
        st.delete("E");
        st.delete("F");
        st.delete("G");
        st.delete("H");
        st.delete("I");
        st.delete("J");
        st.delete("K");
        st.delete("L");
        st.delete("M");
        st.delete("N");
        st.delete("O");
        st.delete("P");


    }
}