package chapter2.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise_2_2_21_FindCommonInThreeList {

    private  int count;

    public List<String> find(List<List<String>> names)
    {
        if(names.size()<=1) return names.get(0);

        List<List<String>> tmp = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            Collections.sort(names.get(i));
        }

        for(int i = 1; i<names.size(); i++)
        {
            List<String> l1 = names.get(i-1);
            List<String> l2 = names.get(i);
            List<String> r1 = merge(l1, l2);
            tmp.add(r1);
        }

        return find(tmp);
    }

    public List<String> merge(List<String> l1, List<String> l2)
    {
        List<String> res = new ArrayList<>();
        int n1 = 0;
        int n2 = 0;

        for (int i = 0; i < l1.size()+l2.size(); i++) {

            if(n1>=l1.size())
            {
                n2++;
            }
            else if(n2>=l2.size())
            {
               n1++;
            }
            else if(l1.get(n1).compareTo(l2.get(n2))< 0)
            {
                n1++;
            }
            else if(l1.get(n1).compareTo(l2.get(n2)) > 0)
            {
                n2++;
            }
            else
            {
                res.add(l1.get(n1));
                n1++;
                n2++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Exercise_2_2_21_FindCommonInThreeList triple = new Exercise_2_2_21_FindCommonInThreeList();
        List<List<String>> ls = generateNames2();
        List<String> res = triple.find(ls);
        for (String s: res)
        {
            StdOut.println(s);
        }
    }

    private static List<List<String>> generateNames2() {
        List<String> namesList1 = new ArrayList<>();
        namesList1.add("Name1");
        namesList1.add("Name4");
        namesList1.add("Name3");
        namesList1.add("Name2");

        List<String> namesList2 = new ArrayList<>();
        namesList2.add("Name5");
        namesList2.add("Name8");
        namesList2.add("Name2");
        namesList2.add("Name1");

        List<String> namesList3 = new ArrayList<>();
        namesList3.add("Name1");
        namesList3.add("Name5");
        namesList3.add("Name2");
        namesList3.add("Name9");

        List<List<String>> names = new ArrayList<>();
        names.add(namesList1);
        names.add(namesList2);
        names.add(namesList3);

        return names;
    }

}
