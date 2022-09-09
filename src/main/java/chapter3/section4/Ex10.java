package chapter3.section4;

import chapter3.LinearProbingHashTable;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdOut;


public class Ex10<Key, Value> extends LinearProbingHashTable<Key,Value> {

    @Override
    protected int hash(Key key) {

        return 11* key.hashCode()% M;
    }

    public Ex10()
    {
        super();
    }

    public Ex10(int M ){
        super(M);
    }

    public static void main(String[] args) {
        Ex10<Character ,Character> hsh = new Ex10<>();
        Character keys[] ={'E','A','S','A','Q','U','T','I','O','N'};

        for(Character i:keys)
        {
            hsh.put(i,i);
            StdOut.print(hsh.hash(i) +", ");
        }
        StdOut.println();

        for(Character c: hsh.keys())
        {
            StdOut.print(c+", ");
        }

        StdOut.println();
        Ex10<Character ,Character> hsh1 = new Ex10<>(10);
        for(Character i:keys)
        {
            hsh1.put(i,i);
            StdOut.print(hsh1.hash(i) +", ");
        }
        StdOut.println();

        for(Character c: hsh1.keys())
        {
            StdOut.print(c+", ");
        }

    }
}
