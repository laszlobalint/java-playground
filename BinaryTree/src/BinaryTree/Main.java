package BinaryTree;

public class Main {

    public static void main(String[] args) {

        //Create new tree:
        NodeClass bt = new NodeClass();

        //Insert into the tree:
        bt.insert(6);
        bt.insert(4);
        bt.insert(8);
        bt.insert(3);
        bt.insert(5);
        bt.insert(7);
        bt.insert(9);

        //Contains the tree:
        System.out.println("Contains 6: " + bt.containsNode(6));
        System.out.println("Contains 4: " + bt.containsNode(4));
        System.out.println("Contains 1: " + bt.containsNode(1));

        //Remove from tree:
        System.out.println("Contains 9 before deletion: " + bt.containsNode(9));
        bt.delete(9);
        System.out.println("Contains 9 after deletion: " + bt.containsNode(9));

        bt.insert(9);

        //In-order traversal search:
        System.out.print("In-order:"); bt.traverseInOrder(bt.root);

        System.out.println();

        //Pre-order traversal search:
        System.out.print("Pre-order:"); bt.traversePreOrder(bt.root);

        System.out.println();

        //Post-order traversal search:
        System.out.print("Post-order:"); bt.traversePostOrder(bt.root);

        System.out.println();

        //Level-order traversal search:
        System.out.print("Level-order:"); bt.traverseLevelOrder();

        System.out.println();

        //Size of the tree:
        System.out.print("Size of the tree: " + bt.getSize());
    }
}