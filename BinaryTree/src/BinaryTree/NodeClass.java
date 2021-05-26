package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class NodeClass {

    public TreeNode root = null;
    private TreeNode actual = null;
    private int size;

    private TreeNode insertNodeRecursive(int value, TreeNode node) {
        if (node == null) {
            return new TreeNode(value, null, null);
        } else {
            if (node.getValue() > value) {
                node.setLeft(insertNodeRecursive(value, node.getLeft()));
                return node;
            } else if (node.getValue() < value) {
                node.setRight(insertNodeRecursive(value, node.getRight()));
                return node;
            } else {
                return node;
            }
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value, null, null);
        } else {
            insertNodeRecursive(value, root);
        }
    }

    private boolean containsNodeRecursive(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        return value < node.value
                ? containsNodeRecursive(node.left, value)
                : containsNodeRecursive(node.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (value == node.value) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            findSmallestValue(root);
            int smallestValue = findSmallestValue(node.right);
            node.value = smallestValue;
            node.right = deleteRecursive(node.right, smallestValue);
            return node;
        }
        if (value < node.value) {
            node.left = deleteRecursive(node.left, value);
            return node;
        }
        node.right = deleteRecursive(node.right, value);
        return node;
    }

    private int findSmallestValue(TreeNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(int value) {
        deleteRecursive(root, value);
    }

    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(TreeNode node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }
        Queue <TreeNode> nodes = new LinkedList <>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            System.out.print(" " + node.value);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public int getSize() {
        if (root == null) {
            return size;
        }
        Queue <TreeNode> nodes = new LinkedList <>();
        nodes.add(root);
        size++;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            if (node.left != null) {
                nodes.add(node.left);
                size++;
            }
            if (node.right != null) {
                nodes.add(node.right);
                size++;
            }
        }
        return size;
    }
}
