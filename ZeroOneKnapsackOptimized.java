import java.util.Arrays;

public class ZeroOneKnapsackOptimized {
	public static void main(String[] args) {
		// based on pseudo code and explanation in Algorithms Illuminated Book Part 3
		// this problem is defined by 2n + 1 integer inputs

		int[] values = {3, 2, 4, 4};
		int[] sizes = {4, 3, 2, 3};
		int capacity = 6;
		
		System.out.println("\n\nItem values: " + Arrays.toString(values));
		System.out.println("Item sizes:  " + Arrays.toString(sizes));
		System.out.println("Capacity of knapsack: " + capacity + "\n");

		int itemCount = values.length;			
		
		// one item in each rows
		// all capacities starting from 0 in each column
		int[][] cache = new int[itemCount+1][capacity+1];
		
		for(int itemIndex=1; itemIndex<itemCount+1; itemIndex++) {
			for (int currCapacity=1; currCapacity < capacity+1; currCapacity++) {
				
				System.out.println("Calculating maximum values of chosen items for knapsack with capacity: " + currCapacity + " with item numbers in range [1, " + itemIndex + "]"); 
				
				if (sizes[ itemIndex-1 ] > currCapacity) {
					cache[ itemIndex ][ currCapacity ] = cache[ itemIndex-1 ] [ currCapacity ];
				} else {
					int remainingCapacity = currCapacity-sizes[ itemIndex-1 ];
					cache[ itemIndex ][ currCapacity ] = Math.max( cache[ itemIndex-1 ][ currCapacity ], cache[ itemIndex-1 ][ remainingCapacity ] + values[ itemIndex-1 ]);
				}
			}
			System.out.println();
		}

		System.out.println("\nMaximum value of items in knapsack given the constraints is: " + cache[ itemCount ][ capacity ]);

		// Reconstruction
		System.out.println("\n\nFollowing items have been chosen to maximize total value of contents in knapsack\n");

		int remainingCapacity = capacity;

		for(int itemIndex = itemCount; itemIndex > 0; itemIndex--) {
			
			if (remainingCapacity - sizes[ itemIndex-1 ] >= 0 && cache[ itemIndex-1 ][ remainingCapacity - sizes[ itemIndex-1] ] + values[ itemIndex-1 ] >= cache[ itemIndex-1 ][ remainingCapacity ]) {
				System.out.println("Item with value: " + values[itemIndex-1] + " and size: " + sizes[itemIndex-1]);
				remainingCapacity -= sizes[ itemIndex-1 ];	
			}
		}

		System.out.println("\n\n");
	}
}
