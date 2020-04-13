# https://leetcode.com/problems/diameter-of-binary-tree/solution/
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Integer}
def diameter_of_binary_tree(root)
  return 0 if root.nil?
  [
    (height(root.left) + height(root.right)),
    [diameter_of_binary_tree(root.left), diameter_of_binary_tree(root.right)].max
  ].max
end

def height(node)
  return 0 if node.nil?
  [height(node.left), height(node.right)].max + 1
end