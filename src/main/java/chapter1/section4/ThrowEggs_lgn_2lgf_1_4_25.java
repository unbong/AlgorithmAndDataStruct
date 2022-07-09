package chapter1.section4;

public class ThrowEggs_lgn_2lgf_1_4_25 {



    public static void main(String[] args) {

        int[] floorArray = {0,0,0,0,0,0,0,0,0,1,1,1,1};
        int high =floorArray.length-1;
        int low = 0;

        ThrowEggs_lgn_2lgf_1_4_25 egg = new ThrowEggs_lgn_2lgf_1_4_25();
        int res =    egg.throwEggsLgn(floorArray, low, high);
        System.out.println("res: " + res);

        res = egg.throwEggs2Lgf(floorArray, low, high);

        System.out.println("res: " + res);
    }

    public int throwEggsLgn(int[] floorArray, int low, int high)
    {

        while(low<= high)
        {
            int mid = low + (high-low)/2;
            System.out.println("debug mid:" + mid);
            if(floorArray[mid] < 1)
            {
                low = mid+ 1;
            }
            else {
                if( mid>= 1 && floorArray[mid-1] == 0)
                {
                    return mid;
                } else {
                  high = mid-1;
                }

            }
        }

        return -1;
    }


    public int throwEggs2Lgf(int[] floorArray, int low, int high)
    {
        // 从1 开始乘上2，寻找 会碎的高度
        int start = 1;
        while(start < floorArray.length)
        {
            if(floorArray[start] == 1 )
            {
                break;
            }

            start = start *2;
        }

        System.out.println("debug: initial floor :" + start);

        low = start/2;
        high = Math.min(start, high-1);

        int res = throwEggsLgn(floorArray, low, high);

        return res;

    }


}
