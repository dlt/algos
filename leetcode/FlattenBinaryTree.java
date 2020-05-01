class Solution {
    public void flatten(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();

        helper(root, q);

        TreeNode curr = q.poll();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            curr.left = null;
            curr.right = node;
            curr = curr.right;
        }
    }

    public void helper(TreeNode node, Queue<TreeNode> q) {
        if (node == null) return;
        q.add(node);
        helper(node.left, q);
        helper(node.right, q);
    }
}
