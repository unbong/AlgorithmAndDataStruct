package chapter2.section2.exercise;

import chapter2.Merge;
import chapter2.MergeBU;
import chapter2.SortCompare;
import edu.princeton.cs.algs4.StdOut;

/**
 * D:\devtools\jdk8\bin\java.exe "-javaagent:D:\devtools\intelliJ\IntelliJ IDEA 2021.1.3\lib\idea_rt.jar=53633:D:\devtools\intelliJ\IntelliJ IDEA 2021.1.3\bin" -Dfile.encoding=UTF-8 -classpath D:\devtools\jdk8\jre\lib\charsets.jar;D:\devtools\jdk8\jre\lib\deploy.jar;D:\devtools\jdk8\jre\lib\ext\access-bridge-64.jar;D:\devtools\jdk8\jre\lib\ext\cldrdata.jar;D:\devtools\jdk8\jre\lib\ext\dnsns.jar;D:\devtools\jdk8\jre\lib\ext\jaccess.jar;D:\devtools\jdk8\jre\lib\ext\jfxrt.jar;D:\devtools\jdk8\jre\lib\ext\localedata.jar;D:\devtools\jdk8\jre\lib\ext\nashorn.jar;D:\devtools\jdk8\jre\lib\ext\sunec.jar;D:\devtools\jdk8\jre\lib\ext\sunjce_provider.jar;D:\devtools\jdk8\jre\lib\ext\sunmscapi.jar;D:\devtools\jdk8\jre\lib\ext\sunpkcs11.jar;D:\devtools\jdk8\jre\lib\ext\zipfs.jar;D:\devtools\jdk8\jre\lib\javaws.jar;D:\devtools\jdk8\jre\lib\jce.jar;D:\devtools\jdk8\jre\lib\jfr.jar;D:\devtools\jdk8\jre\lib\jfxswt.jar;D:\devtools\jdk8\jre\lib\jsse.jar;D:\devtools\jdk8\jre\lib\management-agent.jar;D:\devtools\jdk8\jre\lib\plugin.jar;D:\devtools\jdk8\jre\lib\resources.jar;D:\devtools\jdk8\jre\lib\rt.jar;D:\workspace\IntelliJIDEA_workspace\AlgorithmLearn\target\classes;D:\workspace\IntelliJIDEA_workspace\AlgorithmLearn\src\algs4.jar;D:\devtools\maven\apache-maven-3.8.1\repository\org\slf4j\slf4j-api\1.7.36\slf4j-api-1.7.36.jar;D:\devtools\maven\apache-maven-3.8.1\repository\org\jetbrains\annotations\23.0.0\annotations-23.0.0.jar chapter2.section2.exercise.Exercise_2_2_28
 * t1 16.00, t2 0.00
 * t1 16.00, t2 78.00
 * t1 297.00, t2 365382.00
 *
 * 进程已结束,退出代码0
 */
public class Exercise_2_2_28 {

    public static void main(String[] args) {

        double t1 =SortCompare.timeRandomInput(Merge.class, 1000,1);
        double t2 = SortCompare.timeRandomInput(MergeBU.class, 1000,1);

        StdOut.println(String.format("t1 %.2f, t2 %.2f", t1, t2));


         t1 =SortCompare.timeRandomInput(Merge.class, 10000,1);
         t2 = SortCompare.timeRandomInput(MergeBU.class, 10000,1);
        StdOut.println(String.format("t1 %.2f, t2 %.2f", t1, t2));
         t1 =SortCompare.timeRandomInput(Merge.class, 1000000,1);
         t2 = SortCompare.timeRandomInput(MergeBU.class, 1000000,1);
        StdOut.println(String.format("t1 %.2f, t2 %.2f", t1, t2));
    }
}
