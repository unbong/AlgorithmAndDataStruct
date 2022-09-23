package chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolDigraph {
    private ST<String , Integer> st;
    private String[] keys;
    private boolean marked[];
    public Digraph dg;

    public SymbolDigraph(String stream, String delim)
    {
        st = new ST<>();
        In in = new In(stream);
        while(in.hasNextLine())
        {
            String a[] = in.readLine().split(delim);
            for (int i = 0; i < a.length; i++) {
                if(!st.contains(a[i])){
                    st.put(a[i],st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String name: st.keys())
        {
            keys[st.get(name)] = name;
        }

        dg = new Digraph(st.size());
        in = new In(stream);

        while(in.hasNextLine())
        {
            String a[] = in.readLine().split(delim);
            int v = st.get(a[0]);

            for (int i = 1; i < a.length; i++) {
                dg.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s ) {return st.contains(s);}
    public int index(String s) {return st.get(s);}
    public String name(int v) {return keys[v];}
    public Digraph graph() {return dg;}
}
