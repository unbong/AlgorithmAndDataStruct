package neetcode150.array;

import java.util.*;

public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {


        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i< s.length();i++)
        {
            Character c = s.charAt(i);
            if(map.containsKey(c))
            {
                int val = map.get(c).intValue();
                map.put(c,++val );
            }
            else
                map.put(c, 1);
        }

        for(int i = 0; i< t.length(); i++){
            Character c = t.charAt(i);
            if(! map.containsKey(c))
            {
                return false;
            }
            else{
                int val = map.get(c).intValue();
                map.put(c, --val);
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet())
        {
            if( entry.getValue().intValue() != 0)
               return false;
        }
        return true;

//        if(s.length() != t.length()) return false;
//        char [] char_s = s.toCharArray();
//        char [] char_t = t.toCharArray();
//        Arrays.sort(char_s);
//        Arrays.sort(char_t);
//
//        for(int i = 0; i< char_s.length; i++){
//            if(char_s[i] != char_t[i])
//                return false;
//        }
//
//        return true;
    }

    public static void main(String[] args) {

        IsAnagram_242 i = new IsAnagram_242();
        assert false == i.isAnagram("anagram", "nagaram") : "failed";

        assert false == i.isAnagram("abcd", "c");

        assert false == i.isAnagram("abcd", "cg");

        assert false == i.isAnagram("aacc", "ccca");

    }
}
