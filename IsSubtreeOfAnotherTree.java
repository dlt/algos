/**
https://leetcode.com/problems/subtree-of-another-tree/submissions/

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return find(s, t);
    }
    
    public boolean find(TreeNode haystack, TreeNode needle) {
        Stack<TreeNode> stack = new Stack();
        stack.push(haystack);
        
        TreeNode curr = null;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            
            if (curr != null) {
                if (isEqual(curr, needle)) {
                    return true;
                }
                stack.push(curr.left);
                stack.push(curr.right); 
            }

        }
        
        return false;
    }
    
    public boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        
        if (t1.val != t2.val) return false;
        
        return isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
    }
}