package ee.ttu.algoritmid.hackathon;

/**
 * Tree taken from https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
 */
class BinarySearchTree {
    /* Class containing left
    and right child of current node
    and extroversion value*/
    class Node {
        HackathonParticipant participant;
        double extroversion;
        Node left, right;

        public Node(HackathonParticipant participant) {
            this.participant = participant;
            this.extroversion = participant.getExtroversionLevel();
            this.left = null;
            this.right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls deleteRec()
    void deleteextroversion(double extroversion) {
        root = deleteRec(root, extroversion);
    }

    /* A recursive function to
    delete an existing extroversion in BST
    */
    Node deleteRec(Node root, double extroversion) {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (extroversion < root.extroversion)
            root.left = deleteRec(root.left, extroversion);
        else if (extroversion > root.extroversion)
            root.right = deleteRec(root.right, extroversion);

            // if extroversion is same as root's
            // extroversion, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.extroversion = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.extroversion);
        }
        return root;
    }

    double minValue(Node root) {
        double minv = root.extroversion;
        while (root.left != null) {
            minv = root.left.extroversion;
            root = root.left;
        }
        return minv;
    }

    // This method mainly calls insertRec()
    void insert(HackathonParticipant participant) {
        root = insertRec(root, participant);
    }

    /* A recursive function to
    insert a new extroversion in BST */
    Node insertRec(Node node, HackathonParticipant participant) {
        /* If the tree is empty,
        return a new node */
        if (node == null) {
            node = new Node(participant);
            if (root == null) root = node;
            return node;
        }

        /* Otherwise, recur down the tree */
        if (node.extroversion > participant.getExtroversionLevel())
            node.left = insertRec(node.left, participant);
        else if (node.extroversion < participant.getExtroversionLevel())
            node.right = insertRec(node.right, participant);

        /* return the (unchanged) node pointer */
        return node;
    }

    /*
        void search(HackathonParticipant participant) {
            root = (Node) searchNode(root, participant);
        }
    */
    HackathonParticipant searchNode(HackathonParticipant participant) {
        Node node = root;
        if (root == null) return null;
        HackathonParticipant closestTeammate = null;
        double extroMinDifference = 7.5001;

        double teammateExtroversion = participant.getExtroversionLevel();
        while (node != null) {

            if (node.extroversion == teammateExtroversion) return node.participant;
            double difference = Math.abs(node.extroversion - teammateExtroversion);
            if (difference < extroMinDifference) {
                extroMinDifference = difference;
                closestTeammate = node.participant;
            }
            if (difference == extroMinDifference && node.extroversion < teammateExtroversion) {
                extroMinDifference = difference;
                closestTeammate= node.participant;
            }

            if (teammateExtroversion > node.extroversion) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return closestTeammate;
    }


    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.extroversion + " ");
            inorderRec(root.right);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        /*
        BinarySearchTree tree = new BinarySearchTree();

        / Let us create following BST
            50
        /	 \
        30	 70
        / \ / \
        20 40 60 80 /
        tree.insert(50);
        tree.insert(40);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(
                "Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteextroversion(20);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteextroversion(30);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteextroversion(50);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();

         */


    }
}
