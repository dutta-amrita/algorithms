import java.util.*;

public class MaxPriorityQueue{
	public static void main(String[] args){
		int[] nums = {4, 5, 1, 9, 2, 7, 4, 8, 6, 0, 1, 7, 1};
		printAscending(nums);
	}

	private static void printAscending(int[] nums){
		int len = nums.length;
		PriorityQueue<Integer> sorted = new PriorityQueue<>(len, new Comparator<Integer>() {
			public int compare(Integer a, Integer b){
				return a >= b ? -1 : 1;
			}
		});
		for(int n : nums) {
			sorted.offer(n);
		}
		while(sorted.size() > 0) {
			if (sorted.size() == 1) {
				System.out.println(sorted.poll());
			} else {
				System.out.println(sorted.poll() + ", ");
			}
		}
	} 
}
