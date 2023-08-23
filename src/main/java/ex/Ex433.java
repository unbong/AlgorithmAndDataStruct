package ex;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Ex433 {


    public static int minMutation(String start  , String end, String[] bank){

        int count = 0;

        boolean startFlag = false;
        boolean endFlag = false;
        for (int i = 0; i < bank.length; i++) {

            if(startFlag == false) startFlag = bank[i].equals(start);
            if(endFlag == false) endFlag =  bank[i].equals(end);
        }

        if( ( startFlag  && !endFlag)  ){
            for (int i = 0; i < start.length(); i++) {
                if(start.charAt(i) != end.charAt(i))
                    count++;
            }

        }

        else if( (!startFlag  && !endFlag) || ( !startFlag  && endFlag) )
            return -1;
        else
            return -1;

        return count;


    }


    public static void main(String[] args) {

        Integer[] ss = new Integer[20];

        int[] sss= new int[ss.length] ;



        String [] bank ={"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        int s = minMutation("AACCTTGG",
                "AATTCCGG",bank );

        StdOut.println(s);


        int x = Integer.MIN_VALUE;

        StdOut.println(x);
        int y = -x;

        StdOut.println(-x);
    }

}
