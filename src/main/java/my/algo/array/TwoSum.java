package my.algo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
public class TwoSum {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a = s.twoSum(new int[] {2, 7, 11, 15}, 9);
	
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}

	}

}

class Solution {
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer>  map = new HashMap<Integer,Integer>();
    	for(int i=0; i< nums.length; i++) {
    		int complement = target-nums[i];
    		if(map.containsKey(complement)) {
    			return new int[] {map.get(complement), i };
    		}   		
    		map.put(nums[i], i);
    	  
         }
    	throw new IllegalArgumentException("No two sum solution");
    }
}