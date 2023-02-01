class ZeroOneKnapsackRecursive {
	public static void main(String[] args){
		int[] weights = {1, 2, 3, 5};
		int[] values = {40, 20, 30, 100};
		int cap = 7;
		int maxProfit = findMaxProfit(weights, values, weights.length-1, cap);	
		System.out.println("Max profit for given items and cap is: " + maxProfit);	
	}

	static int findMaxProfit(int[] weights, int[] values, int i, int cap) {
		if (i < 0 || cap == 0) {
			return 0;
		}
		int p1 = 0;
		int p2 = 0;

		// pick 
		if (cap - weights[i] >= 0) {
			p1 = values[i] + findMaxProfit(weights, values, i-1, cap-weights[i]);
		}
		// no pick
		p2 = findMaxProfit(weights, values, i-1, cap);

		return Math.max(p1, p2);
	}
}
