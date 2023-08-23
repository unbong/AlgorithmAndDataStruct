package neetcode150.DynamicPrograme;

public class PalindromicSubstrings_647 {

    public int countSubstrings(String s) {
        if(s.length() ==1 ) return 1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            count += find(s, i, i);
            count += find(s, i, i+1);
        }

        return count;
    }

    private int find(String s, int start, int end) {
        if(start < 0 || end > s.length() -1) return 0;
        int count = 0;
        if(s.charAt(start) == s.charAt(end))
        {
            count += find(s, start-1, end+1);
            count++;
        }
        return count;
    }
}
