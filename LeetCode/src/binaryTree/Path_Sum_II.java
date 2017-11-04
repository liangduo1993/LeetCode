package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 *

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree andsum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.
 */
public class Path_Sum_II {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

		if (root == null)
			return ret;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = root;
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
//			System.out.println(stack);
//			if(prev != null)
//			System.out.println(prev.val);

			if (prev == cur.right || (prev == cur.left && cur.right == null)) {
				stack.pop();
				prev = cur;
				continue;
			}
			if ((prev == cur.left || cur.left == null) && cur.right != null) {
				stack.push(cur.right);
				continue;
			}
			if (cur.left != null && prev != cur.left && prev != cur.right) {
				stack.push(cur.left);
				continue;
			}

			if (cur.left == null && cur.right == null) {
				int total = 0;
				for (TreeNode treeNode : stack) {
					total += treeNode.val;
				}
				if (total == sum) {
					ArrayList<Integer> list = new ArrayList<>();
					for (TreeNode treeNode : stack) {
						list.add(treeNode.val);
					}
					//System.out.println(list);
					ret.add(list);
				}
				stack.pop();
				prev = cur;
				continue;
			}

		}
		return ret;
	}

	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(5);
		TreeNode node10 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node6.left = node9;
		node6.right = node10;

		Path_Sum_II test = new Path_Sum_II();
		ArrayList<ArrayList<Integer>> pathSum = test.pathSum(node1, 22);
		System.out.println(pathSum);

	}

}
