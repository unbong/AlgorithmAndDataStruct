package neetcode150.array;

import java.util.*;

public class GroupAnagrams_49 {

    /**
     * 遍历strs时将其中的值进行排序后，以排序后的字符串为键在散列表中进行查询
     *  如果在散列表中找到了，则将strs中未排序的字符串加入到散列表的值的列表中
     *  如果没有找到，则将排序了的字符串作为键，未排序的字符串作为值加入到散列表中
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        List<String> sortedStrs = new ArrayList<>();
        for (String s: strs) {
            char [] sortedChars =s.toCharArray();
            Arrays.sort(sortedChars);
            sortedStrs.add(new String(sortedChars));
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i= 0; i <sortedStrs.size(); i++) {
            String key = sortedStrs.get(i);
            String orgStr = strs[i];
            if(map.containsKey(key))
            {
                List<String> list = map.get(key);
                list.add(orgStr);
                map.put(key, list);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(orgStr);
                map.put(key, list);
            }
        }

        return  new ArrayList<>(map.values());


    }
}
