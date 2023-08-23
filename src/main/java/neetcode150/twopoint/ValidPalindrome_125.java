package neetcode150.twopoint;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer() ;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if((ch>=65 && ch<=90)  || (ch>=48 && ch<=57) || (ch>=97 && ch<=122)) {
                sb.append(s.charAt(i));
            }
        }

        int len = sb.length();
        for (int i = 0; i < len; i++) {
            if(sb.charAt(i) != sb.charAt(len-1-i))
            {
                return false;
            }
        }
        return true;
    }
}
