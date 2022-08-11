package chapter2.section3;

import utils.ArrayUtils;
import utils.IntRandom;

/**
 * 快速 三 向 切分。（ J. Bently， D. McIlroy） 用 将 重复 元素 放 置于 子 数组 两端 的 方式 实现 一个 信息量 最优 的 排序 算法。
 * 使用 两个 索引 p 和 q， 使得 a[ lo.. p- 1] 和 a[ q+ 1.. hi] 的 元素 都 和 a[ lo] 相等。 使用 另外 两个 索引 i 和 j，
 * 使得 a[ p.. i- 1] 小于 a[ lo]， a[ j+ i.. q] 大于 a[ lo]。 在内 循环 中 加入 代码， 在 a[ i] 和 v 相当 时 将其 与 a[ p]
 * 交换（ 并将 p 加 1）， 在 a[ j] 和 v 相等 且 a[ i] 和 a[ j] 尚未 和 v 进行 比较 之前 将其 与 a[ q] 交换。
 * 添加 在 切分 循环 结束 后 将 和 v 相等 的 元素 交换 到 正确 位置 的 代码， 如图 2. 3. 6 所示。
 * 请注意： 这里 实现 的 代码 和 正文 中 给出 的 代码 是 等价 的， 因为 这里 额外 的 交换 用于 和 切分 元素 相等 的 元素，
 * 而 正文 中的 代码 将 额外 的 交换 用于 和 切分 元素 不等 的 元素。
 *
 */
public class Ex22_Fast3WayQuick {

    public static void sort(Comparable a[])
    {
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable a[], int lo, int hi)
    {
        if(lo>=hi) return;
        int i = lo+1;
        int j = hi;
        int lt = lo;
        int gt = hi;
        int p = lo;
        int q = hi;

        Comparable v = a[lo];

        while(i<=gt)
        {
            if(v.compareTo(a[i])>0 ){ ArrayUtils.exch(a, lt++, i++); }
            else if (v.compareTo(a[i]) < 0 ) { ArrayUtils.exch(a, i, gt--); }
            else { i++; }
        }

        sort(a, lo, lt-1);
        sort(a, lt+1, hi);

    }

    public static void main(String[] args) {

        Integer a[] = IntRandom.getIntRandom(9);
        //Integer a[] =  {9, 1, 6, 7, 8, 3, 4, 2, 5};
        ArrayUtils.show(a);
        sort(a);
        ArrayUtils.show(a);
    }
}
