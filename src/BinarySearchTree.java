public class BinarySearchTree {

    public static void main(String[] args) {
        MyTree tree = new MyTree();

        tree.insert(10);
        tree.insert(8);
        tree.insert(15);
        tree.insert(4);
        tree.insert(3);
        tree.insert(14);
        tree.insert(20);
        tree.insert(16);
        tree.insert(17);
        tree.insert(7);
        tree.insert(5);

        tree.remove(4);

        tree.printTree();
    }

    static class MyTree {

        private TreeNode root;

        void insert(int value) {
            var newNode = new TreeNode(value);

            if (root == null) {
                root = newNode;
                return;
            }

            TreeNode lookNode = root;

            while (true) {
                if (lookNode.value == value) {
                    return;
                }

                if (lookNode.value > value) {
                    if (lookNode.left != null) {
                        lookNode = lookNode.left;
                    } else {
                        lookNode.left = newNode;
                    }
                } else {
                    if (lookNode.right != null) {
                        lookNode = lookNode.right;
                    } else {
                        lookNode.right = newNode;
                    }
                }
            }
        }

        TreeNode lookUp(int value) {
            TreeNode lookNode = root;

            while (lookNode != null) {
                if (lookNode.value == value) {
                    return lookNode;
                }

                if (lookNode.value > value) {
                    lookNode = lookNode.left;
                } else {
                    lookNode = lookNode.right;
                }
            }

            return null;
        }

        void remove(int value) {
            TreeNode parent = root;
            TreeNode node = parent;

            while (node != null) {
                if (node.value == value) {
                    break;
                }

                parent = node;

                if (node.value > value) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            if (node == null) {
                return;
            }

            if (parent == node) {
                root = null;
                return;
            }

            // is leaf
            if (node.left == null && node.right == null) {
                if (parent.right == node) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }

                return;
            }

            // has right child
            if (node.right != null) {
                // need to get the smallest left children

                TreeNode smallestParent = node;
                TreeNode smallest = node.right;

                while (smallest.left != null) {
                    smallestParent = smallest;
                    smallest = smallest.left;
                }

                if (smallestParent.right == smallest) {
                    smallestParent.right = null;
                } else {
                    smallestParent.left = smallest.right;
                }

                // smallest needs to point to parent right

                if (parent.right == node) {
                    parent.right = smallest;
                } else {
                    parent.left = smallest;
                }

                smallest.right = node.right;
                smallest.left = node.left;

            } else {
                if (parent.right == node) {
                    parent.right = node.left;
                } else {
                    parent.left = node.left;
                }
            }
        }

        void printTree() {
            traverseTree(root);
        }

        private void traverseTree(TreeNode node) {
            if (node == null) {
                return;
            }

            System.out.println(node);

            traverseTree(node.left);
            traverseTree(node.right);
        }

    }

    static class TreeNode {

        TreeNode(int value) {
            this.value = value;
        }

        private final int value;
        private TreeNode left;
        private TreeNode right;

        @Override
        public String toString() {
            return "Value: " + value +
                    " Left: " + (left != null ? left.value : null) +
                    " Right: " + (right != null ? right.value : null);
        }
    }
}
