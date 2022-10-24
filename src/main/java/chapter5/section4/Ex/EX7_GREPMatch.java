package chapter5.section4.Ex;

import chapter5.section4.NFA;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EX7_GREPMatch {
    public static void main(String[] args) {
        String regexp = args[0] ;

        NFA nfa = new NFA(regexp);
        while(StdIn.hasNextLine()){
            String txt =  StdIn.readLine();
            if(nfa.recognizes(txt))
                StdOut.println(txt);
        }
    }
}
