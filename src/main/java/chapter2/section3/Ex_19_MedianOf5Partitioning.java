package chapter2.section3;

import chapter2.Quick;
import chapter2.SortCompare;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import utils.ArrayUtils;
import utils.IntRandom;

import java.util.Map;
import java.util.TreeMap;

public class Ex_19_MedianOf5Partitioning {

    public static void sort(Comparable a[])
    {
        Map<Comparable, Integer> middle5 = new TreeMap<>();
        sort(a, 0, a.length-1, middle5);

    }

    public static void sort(Comparable a[], int lo, int hi,  Map<Comparable, Integer> middle5)
    {
        if (lo >= hi) return;
        int j = partition(a, lo, hi, middle5);


        sort(a, lo, j-1, middle5);
        sort(a, j+1, hi, middle5);

    }

    private static int partition(Comparable a[], int lo, int hi, Map<Comparable, Integer> middle5)
    {
        int i = lo;
        int j = hi+1;

        if(j-i>5){
            for (int k = 0; k < 5; k++) {
                middle5.put(a[ StdRandom.uniform(i,j)],StdRandom.uniform(i,j));
            }
            int m =0;
            for (Integer item: middle5.values()) {
                if(m == 2)
                {
                    exch(a, lo, item.intValue());
                    break;
                }

                    m++;
            }
            middle5.clear();
        }

        Comparable v = a[lo];

        while(true)
        {
            while(less(a[++i], v)){ if(i == hi) break;}
            while(less(v, a[--j])){ if(j == lo) break; }
            if(i>=j){ break;}
            exch(a, i , j);
        }

        exch(a, lo, j);

        return j;

    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) <0;
    }

    private  static void exch(Comparable a[], int i, int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

//        Integer a[] = IntRandom.getIntRandom(21);
//        ArrayUtils.show(a);
//
//        sort(a);
//        ArrayUtils.show(a);


        int N = 32000;
        for (int i = 0; i < 4; i++) {
            double sentinel =SortCompare.timeRandomInput(Ex_19_MedianOf5Partitioning.class, N, 1);
            double quick = SortCompare.timeRandomInput(Quick.class, N, 1);

            StdOut.println(String.format("middle5 : %.2f, quick : %.2f ", sentinel, quick));
            N = N*2;
        }

        /**
         * D:\devtools\jdk8\bin\java.exe "-javaagent:D:\devtools\intelliJ\IntelliJ IDEA 2021.1.3\lib\idea_rt.jar=35278:D:\devtools\intelliJ\IntelliJ IDEA 2021.1.3\bin" -Dfile.encoding=UTF-8 -classpath D:\devtools\jdk8\jre\lib\charsets.jar;D:\devtools\jdk8\jre\lib\deploy.jar;D:\devtools\jdk8\jre\lib\ext\access-bridge-64.jar;D:\devtools\jdk8\jre\lib\ext\cldrdata.jar;D:\devtools\jdk8\jre\lib\ext\dnsns.jar;D:\devtools\jdk8\jre\lib\ext\jaccess.jar;D:\devtools\jdk8\jre\lib\ext\jfxrt.jar;D:\devtools\jdk8\jre\lib\ext\localedata.jar;D:\devtools\jdk8\jre\lib\ext\nashorn.jar;D:\devtools\jdk8\jre\lib\ext\sunec.jar;D:\devtools\jdk8\jre\lib\ext\sunjce_provider.jar;D:\devtools\jdk8\jre\lib\ext\sunmscapi.jar;D:\devtools\jdk8\jre\lib\ext\sunpkcs11.jar;D:\devtools\jdk8\jre\lib\ext\zipfs.jar;D:\devtools\jdk8\jre\lib\javaws.jar;D:\devtools\jdk8\jre\lib\jce.jar;D:\devtools\jdk8\jre\lib\jfr.jar;D:\devtools\jdk8\jre\lib\jfxswt.jar;D:\devtools\jdk8\jre\lib\jsse.jar;D:\devtools\jdk8\jre\lib\management-agent.jar;D:\devtools\jdk8\jre\lib\plugin.jar;D:\devtools\jdk8\jre\lib\resources.jar;D:\devtools\jdk8\jre\lib\rt.jar;D:\workspace\IntelliJIDEA_workspace\AlgorithmLearn\target\classes;D:\workspace\IntelliJIDEA_workspace\AlgorithmLearn\src\algs4.jar;D:\devtools\maven\apache-maven-3.8.1\repository\org\slf4j\slf4j-api\1.7.36\slf4j-api-1.7.36.jar;D:\devtools\maven\apache-maven-3.8.1\repository\org\jetbrains\annotations\23.0.0\annotations-23.0.0.jar chapter2.section3.Ex_19_MedianOf5Partitioning
         * middle5 : 21.00, quick : 9.00
         * middle5 : 25.00, quick : 15.00
         * middle5 : 27.00, quick : 14.00
         * middle5 : 55.00, quick : 29.00
         *
         * 进程已结束,退出代码0
         */
    }

}
