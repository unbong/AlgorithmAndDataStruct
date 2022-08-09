package chapter2.section3;

import chapter2.Merge;
import com.sun.org.apache.bcel.internal.generic.MethodGen;
import edu.princeton.cs.algs4.StdOut;

/**
 * 参考 https://github.com/w1374720640/Algorithms-4th-Edition-in-Kotlin/blob/master/src/chapter2/section3/ex16_BestCase.kt
 * * 解：最佳情况应该切分数组的次数最少，且交换元素的次数最少
 *  * 对应的行为是：每次切分前第一个元素的值是中位数，且左侧半边都小于第一个值，右半边都大于第一个值
 *  * 先创建一个有序数组，执行快速排序的逆向运算
 *  * 递归左半边（不包括中间值但包括第一个元素）和右半边，直到范围小于等于1
 *  * 递归完左半边和右半边后，取中间值与第一位元素交换
 */
public class Ex_2_3_16 {

    public static void main(String[] args) {

        int arraySize = 9;

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        int[] array = bestCaseArray(arraySize);

        StdOut.print("Best-case array: ");

        for (int i = 0; i < arraySize; i++) {
            StdOut.print(alphabet.charAt(array[i]));
        }

        StdOut.println();
    }

    private static int[] bestCaseArray(int arraySize) {
        int[] bestCaseArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            bestCaseArray[i] = i;
        }

        bestCaseArray(bestCaseArray, 0, arraySize - 1);
        return bestCaseArray;
    }

    private static void bestCaseArray(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;

        bestCaseArray(array, low, middle - 1);
        bestCaseArray(array, middle + 1, high);

        int temp = array[low];
        array[low] = array[middle];
        array[middle] = temp;
    }
}
