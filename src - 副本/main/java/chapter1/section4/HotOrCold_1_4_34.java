package chapter1.section4;

public class HotOrCold_1_4_34 {

    private  int key = 32;
    public static void main(String[] args) {
        int arrays[] = new int[100];
        for (int i = 0; i < 100; i++) {
            arrays[i] = i+1;
        }

        HotOrCold_1_4_34 hot = new HotOrCold_1_4_34();
        int res = hot.findKey(arrays, 0 , arrays.length-1);
        System.out.println("res: " + res);

    }

    private int findKey(int arrays[], int low, int high)
    {

        if (low == high ) return low;

        int mid = low + (high-low)/2;
        int quater = low +(high-low)  /4;
        int threeQuater =  low +(high-low) *3 /4;

        int midComp= Math.abs( arrays[mid] - arrays[key]);
        int quaComp = Math.abs( arrays[quater] - arrays[key]);
        int tqComp =  Math.abs( arrays[threeQuater] - arrays[key]);

        // in mid and quater
        if( tqComp > quaComp && quaComp  >midComp  )
        {
           return  findKey(arrays, quater, mid);
        }

        //
        else if(  tqComp > midComp && midComp > quaComp    )
        {
            // in mid and tq
            if(arrays[quater] - arrays[key] > 0)
            {
                return findKey(arrays, low, quater);
            }
            // in
            else {
                return findKey(arrays, quater, mid );
            }
        }

        else if ( quaComp >  midComp &&  midComp > tqComp)
        {
            // in mid and tq
            if(arrays[threeQuater] - arrays[key] > 0)
            {
               return findKey(arrays, mid, threeQuater);
            }
            // in
            else {
                return findKey(arrays, threeQuater, high);
            }
        }

        else if (  quaComp > tqComp && tqComp < midComp)
        {
            return findKey(arrays, mid, tqComp );
        }
        else if( tqComp == midComp) {
            return (mid+threeQuater)/2;
        }
        else if(midComp == quaComp)
        {
            return (mid+ quater)/2;
        }

        return -1;

    }
}
