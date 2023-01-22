/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
*/

import java.util.*;

public class CyclicSort{
	public static void main(String[] args){
		int[] nums = {5, 2, 1, 2, 3, 1};
		List<Integer> missingNumbers = cyclicSort(nums);
		for(int n : missingNumbers) {
			System.out.println(n);
		}
	}

	private static List<Integer> cyclicSort(int[] nums){
		int i=0;
		while(i < nums.length){
			while(i < nums.length && nums[i] != i+1) { // fully cyclically sorted array [1, 2, 3, 4, 5, 4]
				if (nums[nums[i]-1] != nums[i]) {
					int t = nums[nums[i]-1];
					nums[nums[i]-1] = nums[i];
					nums[i] = t; // {3, 2, 1, 2, 5, 1} 
				} else {
					i += 1;
				}
			}
			i += 1; 
		}

		List<Integer> missing = new ArrayList<>(); 
		for (int k=0; k<nums.length; k++) {
			if (nums[k] != k+1) {
				missing.add(k+1);
			}
		}

		return missing;
	}
}
