public class FindBoundaryElement {
	public static void main(String[] args){
		// driver function
		boolean[] vals = {false, false, true, true, true, true};
		int result = findBoundary(vals);
		System.out.println("Index of leftmost true value in array is: " + result);
	}

	private static int findBoundary(boolean[] nums){
		// skipping validations	such as length check, value check
		int start = 0;
		int end = nums.length-1;

		int boundaryIndex = -1;

		while(start <= end){
			int mid = start + (end - start) / 2;
			if(nums[mid]){
				boundaryIndex = mid;
				end = mid-1;
			} else {
				start = mid+1;
			}
		}

		return boundaryIndex;
	}
}
