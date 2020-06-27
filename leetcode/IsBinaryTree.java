/**

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        long lower = Long.MIN_VALUE;
        long upper = Long.MAX_VALUE;
        
        return helper(root, lower, upper);
    }
    
    public boolean helper(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        
        int val = node.val;
        
        if (val <= lower || val >= upper) return false;
        
        if (!helper(node.right, val, upper)) return false;
        
        if (!helper(node.left, lower, val)) return false;
        
        return true;
    }
}
