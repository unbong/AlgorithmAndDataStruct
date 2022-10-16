package chapter5.section2.Ex;

import chapter5.section2.TernarySearchTrie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex05_TrieST_NonRecurrenceTest {

    @Test
    void put() {

        Ex05_TrieST_NonRecurrence<Integer> st = new Ex05_TrieST_NonRecurrence<>();

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
}