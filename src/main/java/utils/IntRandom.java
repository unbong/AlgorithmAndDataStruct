package utils;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

public class IntRandom {

    public static Integer[] getIntRandom(int size)
    {
        Integer res[] = new Integer[size];

        for (int i = 0; i < size; i++) {
            res[i] =i+1;
        }
        StdRandom.shuffle(res);

        return res;
    }
}
