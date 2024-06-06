package Map;

import java.util.ArrayList;
import java.util.HashMap;

public class Intersection_of_TwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
      return Intersection(nums1, nums2);

    }
    private int[] Intersection(int[] arr1, int[] arr2){
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr1.length; i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i], map.get(arr1[i])+1);
            }
            else{
                map.put(arr1[i], 1);
            }
        }
        ArrayList<Integer> ll = new ArrayList<>();
        for(int i=0;i<arr2.length;i++){
            if(map.containsKey(arr2[i]) && map.get(arr2[i])>0){
                ll.add(arr2[i]);
                map.put(arr2[i], map.get(arr2[i])-1);
            }

        }
        int[] ans = new int[ll.size()];
        for(int i=0;i< ll.size();i++){
            ans[i] = ll.get(i);
        }
        return ans;
    }
}
