package chapter5.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 低位优先排序
 */
public class LeastSignificantDigit {


    /**
     * 低位优先排序
     * @param strings      要排序的数组
     * @param stringLength 前n位比较的次数
     */
    public static void lsdSort(String[] strings, int stringLength){
         int R = 256;
         int N = strings.length;
         String[] aux = new String[N];

        for (int i = stringLength-1; i >=0 ; i--) {

            int count[] = new int[R+1];

            // 统计出现频率
            for (int j = 0; j < N; j++) {
                count[strings[j].charAt(i)+1]++;
            }

            // 转换为索引
            for (int j = 0; j < R; j++) {
                count[j+1] += count[j];
            }

            // 将元素分类
            for (int j = 0; j < N; j++) {
                aux[count[strings[j].charAt(i)]++] = strings[j];
            }

            // 回写
            for (int j = 0; j < N; j++) {
                strings[j] = aux[j];
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = {"vd","rd","we","fd","gw","wa","sw","wq","pd"};

        LeastSignificantDigit.lsdSort(strings,2);

        for (String s: strings){
            StdOut.println(s);
        }


    }
}
