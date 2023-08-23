package neetcode150.slidingwindow;


import java.util.HashMap;

public class PermutationinString_567 {



    public boolean checkInclusion(String s1, String s2){

        int[] alphaCounter = new int[26];
        int windowSize = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            alphaCounter[s1.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s2.length()-windowSize+1; i++) {
            int[] alphaCounter2 = new int[26];
            for (int j = i; j <i+windowSize ; j++) {
                alphaCounter2[s2.charAt(j) - 'a'] ++;
            }
            boolean allEqual = true;
            for (int j = i; j <i+windowSize ; j++) {
                if(alphaCounter2[s2.charAt(j) - 'a'] != alphaCounter[s2.charAt(j) - 'a'])
                {
                    allEqual = false;
                    break;
                }
            }
            if(allEqual) return true;
        }

        return  false;
    }


    /**
     * 比较排序后的s2的窗口子字符串与s1的排序后的字符串 如果相同说明找到
     *
     * 时间复杂度为O(N*lg（windowSize))
     * @param s1
     * @param s2
     * @return
     */
//    public boolean checkInclusion(String s1, String s2) {
//
//        int windowSize = s1.length();
//        char [] sortedS1 = s1.toCharArray();
//        Arrays.sort(sortedS1);
//        for (int i = 0; i < s2.length()-windowSize+1; i++) {
//            char [] sortedSubS2 = s2.substring(i, i+windowSize).toCharArray();
//            Arrays.sort(sortedSubS2);
//            if(Arrays.equals(sortedS1, sortedSubS2))
//            {
//                return true;
//            }
//        }
//
//        return false;
//    }


}
