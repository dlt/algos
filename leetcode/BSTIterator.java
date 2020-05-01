class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        leftMost(root);
    }

    public int next() {
        TreeNode node = stack.pop();

        if (node.right != null)
            leftMost(node.right);

        return node.val;
    }

    private void leftMost(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }
}