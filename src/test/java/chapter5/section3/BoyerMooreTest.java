package chapter5.section3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoyerMooreTest {

    @Test
    void search() {
        BoyerMoore k1 = new BoyerMoore("iamman");
        int i = k1.search("public class BruteForceSubstringSearch implements SubstringSearchiamman");
        int j = k1.search("public class BruteiammanForceSubstringSearch implements SubstringSearch");
        int s = k1.search("public class BruteiammaForceSubstringSearch implements SubstringSearch");

        assertEquals(65, i);
        assertEquals(18, j);
        assertEquals(70, s);
    }
}