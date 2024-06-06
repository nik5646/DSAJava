package Map;

import java.util.Arrays;
import java.util.HashMap;

public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
          return longestSequence(nums);
    }

    private int longestSequence(int[] arr) {
        HashMap <Integer, Boolean> map = new HashMap<>();
        for(int i=0;i< arr.length;i++){
            if(map.containsKey(arr[i]-1)){
                map.put(arr[i], false);// if arr[i]-1 present so this element cant be starting point
            }
            else{
                map.put(arr[i], true);// we are making starting point of sequnce as true
            }
            if(map.containsKey(arr[i]+1)){
                map.put(arr[i]+1, false);//if arr[i]+1 exist we make it flase as it can be starting point now
            }
        }
        int ans = 0;
        for(int key : map.keySet()){
            if(map.get(key)){
                int c = 0;
                while(map.containsKey(key)){
                    c++;
                    key++;
                }
                ans = Math.max(ans, c);
            }
        }
        return ans;
    }
}
