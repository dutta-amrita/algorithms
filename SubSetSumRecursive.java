class SubsetSumRecursive {
	public static void main(String[] args) {
		int[] test1 = {1, 2, 3, 7};
		int sum = 6;
		boolean subsetSumExists = subsetWithSum(test1, sum, test1.length-1);
		System.out.println("Subset with sum exists: " + subsetSumExists);

		int[] test2 = {1, 3, 4, 8};
		sum = 6;
		subsetSumExists = subsetWithSum(test2, sum, test2.length-1);
		System.out.println("Subset with sum exists: " + subsetSumExists);
	}

	static boolean subsetWithSum(int[] nums, int sum, int i) {
		// base case
		if (i < 0) {
			if (sum == 0) {
				return true;
			} else {
				return false;
			}
		}
		
		boolean exists = false;	

		// pick
		exists = subsetWithSum(nums, sum-nums[i], i-1);
		if (!exists) {
			// not pick
			exists = subsetWithSum(nums, sum, i-1);
		}

		return exists; 
	}
}
