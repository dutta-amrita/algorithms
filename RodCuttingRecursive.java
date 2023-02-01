import java.util.Arrays;

class RodCuttingRecursive{
	public static void main(String[] args){
		int maxProfit = 0;

		System.out.println("Test case 1");
		int[] prices = {4, 3};
		int rodLength = 2; // max(4+4, 3)

		maxProfit = rodCutting(prices, rodLength);
		System.out.println("Maximum profit for rodLength: " + rodLength + " and prices: " + Arrays.toString(prices) + " is: " + maxProfit);

		System.out.println("Test case 2");
		prices[1] = 10;
		maxProfit = rodCutting(prices, rodLength); // max(4+4, 10)
		System.out.println("Maximum profit for rodLength: " + rodLength + " and prices: " + Arrays.toString(prices) + " is: " + maxProfit);
	}

	static int rodCutting(int[] prices, int remainingRodLength){
		int maxProfit = 0;

		// iterate over the choices to make a cut
		// pieceLength ==  rodLength means no cut!
		for(int pieceLength = 1; pieceLength <= remainingRodLength; pieceLength++) { // cutLength = 1; cutLength = 2; 
			// price of pieceLength == 1 is given by prices[0] 
			// price of pieceLength == x is given by prices[x-1] 
			// this is due to array indices starting from 0 in Java
			maxProfit = Math.max(maxProfit, prices[pieceLength-1] + rodCutting(prices, remainingRodLength-pieceLength));
		}

		return maxProfit;
	}
}
