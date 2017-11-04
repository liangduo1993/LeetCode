package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values. For
 * example: Given binary tree{1,#,2,3}, 1 \ 2 / 3
 * 
 * return[3,2,1]. Note: Recursive solution is trivial, could you do it
 * iteratively?
 *
 */
public class _06_Postorder_Traversal {

	
	/**
	 * // 要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。     
	 * // 如果P不存在左孩子和右孩子，则可以直接访问它；
	 * // 或者P存在孩子，但是其孩子都已被访问过了，则同样可以直接访问该结点     
	 * // 若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了     
	 * // 每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。     
	**/
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> ret = new ArrayList<>();

		TreeNode last = root;
		stack.push(last);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if ((cur.left == null && cur.right == null) || (last == cur.left || last == cur.right)) {
				stack.pop();
				last = cur;
				ret.add(cur.val);
			} else {

				if (cur.right != null)
					stack.push(cur.right);
				if (cur.left != null)
					stack.push(cur.left);
				System.out.println(stack);
			}

		}

		return ret;
	}

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node6;
		node5.right = node7;
		_06_Postorder_Traversal post = new _06_Postorder_Traversal();
		ArrayList<Integer> list = post.postorderTraversal(node1);
		System.out.println(list);
		
		
	}

}



class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}
	
}
