package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(Group_Anagrams(arr));
    }
    public static List<List<String>> Group_Anagrams(String[] strs) {
        HashMap <String, List<String>> map = new HashMap<>();
        for(int i=0; i< strs.length; i++){
            String s = strs[i];
            String key = GenerateKey(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }

    private static String GenerateKey(String s) {
       int[] freq = new int[26];
       for(int i=0;i<s.length(); i++){
           char ch = s.charAt(i);
           int idx = ch-'a';
           freq[idx]++;
       }
       StringBuilder sb= new StringBuilder();
       for(int i=0;i< freq.length;i++){
           sb.append(freq[i]+" ");
       }
       return sb.toString();
    }


}

