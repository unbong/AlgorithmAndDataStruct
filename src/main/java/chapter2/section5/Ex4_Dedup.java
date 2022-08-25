package chapter2.section5;

import chapter2.Quick;
import utils.ArrayUtils;

public class Ex4_Dedup {

    public static String[] dedup(String a[])
    {
        if(a.length == 0) throw new IllegalArgumentException("a is empty");
        String res[] = new String[a.length];
        Quick.sort(a);
        int j = 0;
        res[j++] = a[0];
        for (int i = 1; i < a.length; i++) {
            if(a[i].compareTo(a[i-1]) >0)
                res[j++] = a[i];
        }

        return res;
    }

    public static void main(String[] args) {
        String[] input = {"Algorithms", "Sedgewick", "Wayne", "Argento", "Djikstra", "Wayne", "Argento", "Prim"};

        String[] s = dedup(input);

        ArrayUtils.show(s);
    }

}
