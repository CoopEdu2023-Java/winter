class AVLNode<T> {
    T value;
    TreeNode left;
    TreeNode right;
    int height;

    public AVLNode(T x) {
        this.value = x;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    private int getBalanceFactor(AVLNode<T> node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    private void updateHeight(AVLNode<T> node) {
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private AVLNode<T> leftRotate(AVLNode<T> node) {
        AVLNode<T> newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        updateHeight(node);
        updateHeight(newNode);
        return newNode;
    }

    private AVLNode<T> rightRotate(AVLNode<T> node) {
        AVLNode<T> newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;
        updateHeight(node);
        updateHeight(newNode);
        return newNode;
    }

    private AVLNode<T> balance(AVLNode<T> node) {
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor == 2) {
            if (getBalanceFactor(node.left) == 1) {
                return rightRotate(node);
            } else if (getBalanceFactor(node.left) == -1) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balanceFactor == -2) {
            if (getBalanceFactor(node.right) == -1) {
                return leftRotate(node);
            } else if (getBalanceFactor(node.right) == 1) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private AVLNode<T> insert(AVLNode<T> root, T x) {
        if (root == null) {
            return new AVLNode<T>(x);
        }
        if (x < root.value) {
            root.left = insert(root.left, x);
        } else {
            root.right = insert(root.right, x);
        }
        updateHeight(root);
        root = balance(root);
        return root;
    }

    public AVLNode<T> remove(AVLNode<T> root, T x) {
        if (root == null) {
            return null;
        }
        if (x < root.value) {
            root.left = remove(root.left, x);
        } else if (x > root.value) {
            root.right = remove(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = findMin(root.right);
            root.right = remove(root.right, root.value);
        }
        updateHeight(root);
        root = balance(root);
        return root;

    }

    private T findMin(BSTNode<T> root) {
        if (root.left == null) {
            return root.value;
        }
        return findMin(root.left);
    }
}