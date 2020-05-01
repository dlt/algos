/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 * <p>
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class NodeEntry {
        int depth;
        TreeNode parent;

        public NodeEntry(int depth, TreeNode parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, NodeEntry> index = new HashMap();
        DFS(index, root, null);
        boolean diffParents = index.get(x).parent != index.get(y).parent;
        boolean sameDepth = index.get(x).depth == index.get(y).depth;
        return diffParents && sameDepth;
    }

    public void DFS(Map<Integer, NodeEntry> index, TreeNode node, TreeNode parent) {
        if (node == null) return;

        if (!index.containsKey(node.val)) {
            index.put(node.val, new NodeEntry(0, parent));
        }

        if (parent != null)
            index.get(node.val).depth = index.get(parent.val).depth + 1;

        DFS(index, node.left, node);
        DFS(index, node.right, node);
    }
}