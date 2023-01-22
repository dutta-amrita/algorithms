public class RodCutting{
	public static void main(String[] args){
		int[] p = {2, 5, 9, 10, 12};
		int maxProfit = recursiveRodCutting(p, p.length);
		System.out.printf("Max profit by optimally cutting rod of length %d is %d%n", p.length, maxProfit);
	}

	static int recursiveRodCutting(int[] p, int n){
		if (n == 0) {
			return 0;
		}
		
		int maxProfit = Integer.MIN_VALUE;
		for (int i=1; i<=n; i++){
			maxProfit = Math.max(maxProfit, p[i-1] + recursiveRodCutting(p, n-i));
		}

		return maxProfit;
	}
}
