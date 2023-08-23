package ex;

public class test {

    private static boolean search(int[] arr, int key)
    {
        int end =  arr.length;
        int start = 0;
        int mid = start+  (end - start) /2;

        while(start <= end)
        {
            if(arr[mid] < key )
            {
                start = mid+1;
            }
            else if(arr[mid]> key)
            {
                end = mid-1;
            }
            else{
                return true;
            }
            mid = start+  (end - start) /2;
        }

        return false;

    }
    public static int[] solution(int[] arr1, int[] arr2) {
        // TODO: Implement me!
        int size = arr1.length > arr2.length ? arr2.length:arr1.length;

        int[] res = new int[size];
        int resIndex=0;
        for(int i =0; i < arr1.length; i++)
        {
            if(search(arr2, arr1[i]))
            {
                res[resIndex++] = arr1[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3,5,6,7};
        int[] a2 = {3,6,7,8,20};

        int []aa=solution(a1, a2);

        for (int i = 0; i < aa.length; i++) {
            System.out.println(aa[i]);
        }
    }
}
