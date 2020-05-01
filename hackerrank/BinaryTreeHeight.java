import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    private static int maxHeight = 0;

    /*
    class Node 
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        goDown(root.left, 0);
        goDown(root.right, 0);
        return maxHeight;
    }

    public static void goDown(Node node, int height) {
        if (maxHeight < height) maxHeight = height;
        if (node == null) return;

        goDown(node.left, height + 1);
        goDown(node.right, height + 1);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
