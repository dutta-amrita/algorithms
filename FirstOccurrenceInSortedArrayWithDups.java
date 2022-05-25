import java.util.*;

public class FirstOccurrenceInSortedArrayWithDups {
	public static void main(String[] args){
		// driver function
		int[] nums = {3, 3, 3, 3, 3, 6, 10, 10, 10, 100};
		int target = 3;
		int index = firstOccurrenceInSortedArrayWithDups(nums, target);
		System.out.println("First occurrence of " + target + " in " + Arrays.toString(nums) + " is at index " + index);
		
		target = 6;
		index = firstOccurrenceInSortedArrayWithDups(nums, target);
		System.out.println("First occurrence of " + target + " in " + Arrays.toString(nums) + " is at index " + index);

		target = 10;
		index = firstOccurrenceInSortedArrayWithDups(nums, target);
		System.out.println("First occurrence of " + target + " in " + Arrays.toString(nums) + " is at index " + index);
		
		target = 100;
		index = firstOccurrenceInSortedArrayWithDups(nums, target);
		System.out.println("First occurrence of " + target + " in " + Arrays.toString(nums) + " is at index " + index);
		
		target = -12;
		index = firstOccurrenceInSortedArrayWithDups(nums, target);
		System.out.println("First occurrence of " + target + " in " + Arrays.toString(nums) + " is at index " + index);
				
		target = 113;
		index = firstOccurrenceInSortedArrayWithDups(nums, target);
		System.out.println("First occurrence of " + target + " in " + Arrays.toString(nums) + " is at index " + index);
	}

	private static int firstOccurrenceInSortedArrayWithDups(int[] nums, int target){// [1, 3, 3, 3, 3, 6, 10, 10, 10, 100]
		// iterative implementation of binary search
		int start = 0;// 0
		int end = nums.length-1;// 9
		// skipping validations
		int boundaryIndex = -1;// -1
		while(start <= end){// 0 <= 3
			int mid = start + (end-start)/2;// 1
			if(nums[mid] == target){// 3 == 3
				boundaryIndex = boundaryIndex != -1 ? Math.min(boundaryIndex, mid) : mid;// 1
				end = mid-1;// 0
			} else if (nums[mid] > target){
				end = mid-1;
			} else {
				start = mid+1;
			}
		}

		return boundaryIndex;
	}
}
