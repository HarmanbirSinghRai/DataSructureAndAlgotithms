package BinaryTreeSearchNonSearch;


/**
 * Date 03/22/2016
 * @author Tushar Roy
 *
 * Given a binary tree, find the maximum path sum. For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 * 
 * Time complexity O(n)
 * Space complexity depends on depth of tree.
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    int max = 0;

    public int maxPathSum(Node root) {
        max =Integer.MIN_VALUE;
        maxPathSumUtil(root);
        return max;
    }

    private int maxPathSumUtil(Node root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSumUtil(root.leftNode);
        int right = maxPathSumUtil(root.rightNode);
        if (left < 0) {
            left = 0;
        }
        if (right < 0) {
            right = 0;
        }
        max = Math.max(max, root.iData + left + right);
        return root.iData + Math.max(left, right);
    }
    
    public static void main(String args[]) {
    	BinaryTreeMaximumPathSum mps = new BinaryTreeMaximumPathSum();
        BST bst = new BST();
		bst.insert(34, 'A');
		bst.insert(64, 'R');
		bst.insert(23, 'Y');
		bst.insert(71, 'E');
		bst.insert(30, 'H');
		bst.insert(33, 'O');
		bst.insert(20, 'W');
		bst.insert(22, 'Q');
		bst.insert(19, 'N');
		bst.insert(66, 'N');
		bst.insert(76, 'D');
		bst.insert(65, 'R');
		bst.insert(85, 'T');
        System.out.println("maxumum sum is "+mps.maxPathSum(bst.root));
        
    }
}