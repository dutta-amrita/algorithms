import java.util.*;
class ListNode{
	private Character key;
	private int val;

	public ListNode(Character key, int val){
		this.key = key;
		this.val = val;
	}

	public Character key() {
		return this.key;
	}

	public int val() {
		return this.val;
	}
}

public class LinkedListRemoveConstantTime{
	
	public static void main(String[] args){
		List<ListNode> list = new LinkedList<>();
		Map<Character, ListNode> cache = new HashMap<>();

		char key = 'a';
		for(int i=1; i<=5; i++){
			ListNode curr = new ListNode(key, i);
		       	list.add(curr);
			cache.put(key, curr);
			key +=1;
		}
		
		print(list);

		// delete node with key 'c'
		ListNode nodeToDelete = cache.get('c');
		list.remove(nodeToDelete);
		
		// invalidate cache
		cache.remove('c');
		
		print(list);
	}

	private static void print(List<ListNode> list){
		// iterate LinkedList in java
		StringBuilder output = new StringBuilder("[");
		Iterator<ListNode> it = list.iterator();
		while(it.hasNext()){
			if (output.length() == 1) {
				output.append(it.next().key());
			} else {
				output.append(", ");
				output.append(it.next().key());
			}
		}
		output.append("]");
		System.out.println(output.toString());
	}
}
