package chapter3.Section5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex8_LPHashST_DuplicateValueTest {

    @Test
    void size() {

        Ex8_LPHashST_DuplicateValue<Integer, Integer> st = new Ex8_LPHashST_DuplicateValue<>();
        st.put(1,1);
        st.put(2,1);
        st.put(3,1);
        st.put(4,1);
        st.put(5,1);
        st.put(6,1);

        st.put(1,1);
        st.put(2,1);
        st.put(3,1);
        st.put(4,1);

        assertEquals(10, st.size());
        st.delete(1);
        assertEquals(8, st.size());

    }

    @Test
    void isEmpty() {
        Ex8_LPHashST_DuplicateValue<Integer, Integer> st = new Ex8_LPHashST_DuplicateValue<>();
        assertEquals(true, st.isEmpty());
        st.put(1,1);
        assertEquals(false, st.isEmpty());
        st.delete(1);
        assertEquals(true, st.isEmpty());
    }

    @Test
    void put() {
        Ex8_LPHashST_DuplicateValue<Integer, Integer> st = new Ex8_LPHashST_DuplicateValue<>();
        st.put(1,1);
        st.put(2,1);
        st.put(3,1);
        st.put(4,1);
        st.put(5,1);
        st.put(6,1);

        st.put(1,1);
        st.put(2,1);
        st.put(3,1);
        st.put(4,1);

        assertThrows(IllegalArgumentException.class,()->{st.put(null, null);});


    }

    @Test
    void delete() {

        Ex8_LPHashST_DuplicateValue<Integer, Integer> st = new Ex8_LPHashST_DuplicateValue<>();
        st.put(1,1);
        st.put(2,2);
        st.put(3,3);
        st.put(4,4);
        st.put(5,5);
        st.put(6,6);

        st.put(1,11);
        st.put(2,22);
        st.put(3,33);
        st.put(4,44);

        assertEquals(10, st.size());
        st.delete(5);
        assertEquals(null, st.get(5));
        assertEquals(9, st.size());

        st.delete(1);
        assertEquals(null, st.get(1));
        assertEquals(7, st.size());

    }

    @Test
    void get() {
    }

    @Test
    void contains() {
    }
}