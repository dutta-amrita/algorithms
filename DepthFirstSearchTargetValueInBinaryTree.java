public class DepthFirstSearchTargetValueInBinaryTree{
	
	// driver function
	public static void main(String[] args){
		/*
		Node five = new Node(5, null, null);
		Node four = new Node(4, null, null);

		Node three = new Node(3, null, five);
		
		Node two = new Node(2, three, four);
		Node six = new Node(6, null, null);
		
		Node one = new Node(1, two, six);
		*/

		Node one = new Node(1, new Node(2, new Node(3, null, new Node(5, null, null)), new Node(4, null, null)), new Node(6, null, null));
		
		int target = 4;

		Node searchedNode = dfs(one, target);
		System.out.println("Value present in returned search node is " + searchedNode.val); 
	}

	// recursive implementation
	private static Node dfs(Node root, int target){
		if (root == null){
			return null;
		}

		if (root.val == target) {
			return root;
		}

		Node leftSearchResult = dfs(root.left, target);
		if(leftSearchResult != null){
			return leftSearchResult;
		}

		return dfs(root.right, target);
	}

	private static class Node{
		int val;
		Node left;
	        Node right;

		Node(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}

		Node(int val, Node left, Node right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
