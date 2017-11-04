package binaryTree;

import java.util.Scanner;

/**
 * Given a binary tree, find its minimum depth.The minimum depth is the number
 * of nodes along the shortest path from the root node down to the nearest leaf
 * node.
 * 
 * @author Liang
 *
 */
public class _01_MiniDepth {
	public int run(TreeNode root) {

		if (root == null)
			return 0;
		int depth = 0;
		int rightDepth = 0;
		int leftDepth = 0;
		rightDepth = run(root.right);
		leftDepth = run(root.left);
		if (root.left == null && root.right == null)
			return 1;
		if (root.left == null && root.right != null)
			return rightDepth + 1;
		if (root.left != null && root.right == null)
			return leftDepth + 1;
		
		
		depth = Math.min(rightDepth, leftDepth) + 1;
		return depth;

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}



}
