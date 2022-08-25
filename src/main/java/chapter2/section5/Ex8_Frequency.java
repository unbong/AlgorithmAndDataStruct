package chapter2.section5;

import chapter2.Quick;
import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;
import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex8_Frequency implements Comparable<Ex8_Frequency> {

    private String item;
    private int count;

    public Ex8_Frequency()
    {

    }

    public Ex8_Frequency(String item){
        this.item = item;
        this.count = 1;
    }

    public void addCount(){
        this.count++;
    }

    public List<Ex8_Frequency> frequency(String[] a)
    {
        Quick.sort(a);
        List<Ex8_Frequency> items = new ArrayList<>();
        items.add(new Ex8_Frequency(a[0]));
        for (int i = 1; i < a.length; i++) {
            if(a[i].compareTo(a[i-1]) ==0)
            {
                Ex8_Frequency it = items.get(items.size()-1);
                it.addCount();
                items.set(items.size()-1, it);
            }
            else{
                items.add(new Ex8_Frequency(a[i]));
            }
        }

        Ex8_Frequency[] exs = new Ex8_Frequency[items.size()];
        items.toArray(exs);
        Quick.sort(exs);
        return items;
    }


    public static void main(String[] args) {
        Ex8_Frequency f = new Ex8_Frequency();

//        Scanner scanner  = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
//        while (scanner.hasNext())
//        {
//            strings.add(scanner.next());
//        }
        strings.add("test");
        strings.add("begin");
        strings.add("end");
        strings.add("abc");
        strings.add("test");
        strings.add("begin");
        strings.add("end");
        strings.add("test");
        strings.add("test");
        strings.add("begin");




        String a[] = new String[strings.size()];
        strings.toArray(a);

        List<Ex8_Frequency> ss =  f.frequency(a);

        ss.forEach(item->StdOut.println(item.item+ " " +item.count));

    }

    @Override
    public int compareTo(@NotNull Ex8_Frequency o) {
        if(this.count > o.count) return 1;
        else if(this.count < o.count) return -1;

        return 0;
    }
}
