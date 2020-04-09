/**

https://leetcode.com/problems/count-univalue-subtrees/submissions/

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int total = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        
        TreeNode curr = null;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            
            if (curr != null) {
                if (isUnivalue(curr)) total+= 1;
                stack.push(curr.left);
                stack.push(curr.right);
            }
        }
        return total;
    }
    
    public boolean isUnivalue(TreeNode node) {
        if (node != null) {
            if (node.left == null && node.right == null) return true;
            
            if (node.left == null && node.right != null) {
                return node.right.val == node.val && isUnivalue(node.right);
            }
            
            if (node.right == null && node.left != null) {
                return node.left.val == node.val && isUnivalue(node.left);
            }
            
            return node.left.val == node.val && node.right.val == node.val && isUnivalue(node.left) && isUnivalue(node.right);
        }
        return false;
    }
}