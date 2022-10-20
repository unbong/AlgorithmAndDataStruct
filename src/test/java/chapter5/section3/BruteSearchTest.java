package chapter5.section3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BruteSearchTest {

    @Test
    void search() {

        int i = BruteSearch.search("iamman","public class BruteForceSubstringSearch implements SubstringSearchiamman");
        int j = BruteSearch.search("iamman","public class BruteiammanForceSubstringSearch implements SubstringSearch");
        int s = BruteSearch.search("iamman","public class BruteiammaForceSubstringSearch implements SubstringSearch");

        assertEquals(65, i);
        assertEquals(18, j);
        assertEquals(70, s);
    }

    @Test
    void search2() {

        int i = BruteSearch.search2("iamman","public class BruteForceSubstringSearch implements SubstringSearchiamman");
        int j = BruteSearch.search2("iamman","public class BruteiammanForceSubstringSearch implements SubstringSearch");
        int s = BruteSearch.search2("iamman","public class BruteiammaForceSubstringSearch implements SubstringSearch");

        assertEquals(65, i);
        assertEquals(18, j);
        assertEquals(70, s);
    }

    @Test
    void testSearch() {

        BruteSearch s1 = new BruteSearch("iamman");
        int i = s1.search("iamman","public class BruteForceSubstringSearch implements SubstringSearchiamman");
        int j = s1.search("iamman","public class BruteiammanForceSubstringSearch implements SubstringSearch");
        int s = s1.search("iamman","public class BruteiammaForceSubstringSearch implements SubstringSearch");

        assertEquals(65, i);
        assertEquals(18, j);
        assertEquals(70, s);
    }
}