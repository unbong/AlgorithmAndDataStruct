package neetcode150.DynamicPrograme;

public class LongestPalindromicSubstring_5 {

    /**
     * 从一个字符和两个字符相等的情况开始，逐渐的扩展返回使得基于会问字符串的基础上找到更大范围的回文
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s.length() == 1) return s;
        String first = "" ;
        String second = "";

        // 两个字符相同的模式
        for (int i = 0; i < s.length() -1; i++) {
            if(s.charAt(i) == s.charAt(i+1))
            {
                String res = find(s, i, i+1);
                if(first.length() < res.length()) first = res;
            }
        }

        // 根据一个字符逐渐扩展的模式
        for (int i = 0; i < s.length()  ; i++) {
            String res = find(s,i,i);
            if( res != null && second.length() < res.length()) second = res;
        }

        if(first.length()> second.length())
            return  first;
        else
            return second;
    }

    private String find(String s, int start, int end) {
        if(start < 0 || end >= s.length()) return null;

        if(s.charAt(start) != s.charAt(end)) return null;
        String res = find(s, start-1, end+1);

        if(res == null)
            return s.substring(start, end+1);
        else{
            return res;
        }
    }
}
