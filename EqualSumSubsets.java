public class EqualSumSubsets{
	public static void main(String[] args) {
		int[] numbers1 = {2, 1, 4, 7};
		boolean twoEqualSumSubsetsPossible = false;
		
		twoEqualSumSubsetsPossible = bruteForce(numbers1);
		System.out.println(twoEqualSumSubsetsPossible);

		int[] numbers2 = {3, 12, 7};
		twoEqualSumSubsetsPossible = bruteForce(numbers2);
		System.out.println(twoEqualSumSubsetsPossible);
	}

	static boolean bruteForce(int[] numbers) {
		int sumNumbers = 0;
		for (int i=0; i<numbers.length; i++) {
			sumNumbers += numbers[i];
		}

		if (sumNumbers % 2 != 0) {
			return false;
		}

		int targetSum = sumNumbers/2;
		
		return bruteForceRecursive(numbers, 0, 0, targetSum);
	}

	static boolean bruteForceRecursive(int[] numbers, int index, int currentSum, int targetSum){
		// pruning
		if (currentSum == targetSum) {
			return true;
		}

		if (index == numbers.length || currentSum > targetSum) {
			return false;
		}
		
		boolean twoEqualSumSubsetsPossible = bruteForceRecursive(numbers, index+1, currentSum, targetSum);
		if (twoEqualSumSubsetsPossible) {
			return true;
		}

		currentSum += numbers[index];		
		return bruteForceRecursive(numbers, index+1, currentSum, targetSum);			
	}
}
