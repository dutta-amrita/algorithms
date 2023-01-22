/*
Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
Note that the letters wrap around.

For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
*/

import java.util.*;

public class NextGreatestLetter {
	public static char nextGreatestLetter(char[] letters, char target) {
        	// given, letters.length >=2, skipping length validation
       		int start = 0;
        	int end = letters.length -1;
        	char nextGreatest = ' ';
        	while(start <= end) {
            		int mid = start + (end - start) / 2;
            		if (target < letters[mid]) {
                		nextGreatest = letters[mid];
                		end = mid - 1;
            		} else {
                		start = mid + 1;
            		}
        	}
        	if (nextGreatest == ' '){
            		return letters[0];
        	}
        	return nextGreatest;
	}
	
	public static void main(String[] args){
		char result = ' ';

		char[] input1 = {'c', 'f', 'j'};
		char target1 = 'a';
		result = nextGreatestLetter(input1, target1);
		System.out.println("Next greatest letter in " + Arrays.toString(input1) + " for target " + target1 + " is " + result);
                char target2 = 'c';
                result = nextGreatestLetter(input1, target2);
                System.out.println("Next greatest letter in " + Arrays.toString(input1) + " for target " + target2 + " is " + result);

		char[] input2 = {'x', 'x', 'y', 'y'};
                char target3 = 'z';
                result = nextGreatestLetter(input2, target3);
                System.out.println("Next greatest letter in " + Arrays.toString(input2) + " for target " + target3 + " is " + result);
                char target4 = 'y';
                result = nextGreatestLetter(input2, target4);
                System.out.println("Next greatest letter in " + Arrays.toString(input2) + " for target " + target4 + " is " + result);
	}
}
