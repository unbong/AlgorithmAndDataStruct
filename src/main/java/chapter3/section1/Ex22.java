package chapter3.section1;

public class Ex22<Key extends Comparable<Key> ,Value> {

    private Key[] keys;
    private Value[] values;
    private Integer [] frequent;
    private int size;



    public void put(Key k, Value v)
    {
        if(k == null) throw new IllegalArgumentException("key is null");
        if(v == null) throw new IllegalArgumentException("value is null");

        if(size == keys.length) resize(2*keys.length);

        int i = find(k);


        if( i!= -1)
        {
            values[i] = v;
        }
        else {
            values[++size] = v;
        }


    }

    private void resize(int i) {

    }

    public Value get(Key k)
    {
        if(k == null) throw new IllegalArgumentException("key is null");
        int i = find(k);
        if(i!=-1)
        {
            return values[i];
        }
        return null;
    }

    public void delete(Key k)
    {
        if(k == null) throw new IllegalArgumentException("key is null");
        int i = find(k);
        if(i!=-1)
        {

            for (int j = i; j <size-1; j++) {
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
            keys[size] = null;
            values[size] = null;
            size--;
        }
    }

    public boolean isEmpty()
    {
        return size ==0;
    }

    public boolean contaain(Key k)
    {
        return false;
    }

    public int size() {return size;}

    public int find(Key key)
    {
        int i = 0;
        for (; i < keys.length; i++) {
            if(key.compareTo(keys[i]) == 0)
            {
                return i;
            }
        }
        if(i == keys.length )
            return -1;
        else
        {
            Value tmp = values[i];
            for (int j = i; j >0; j--) {
                keys[j] = keys[j-1];
                values[j] = values[j-1];
            }
            keys[0] = key;
            values[0] = tmp;
        }
        return 0;
    }
}
