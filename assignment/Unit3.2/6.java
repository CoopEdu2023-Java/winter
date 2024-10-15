class BSTNode<T> {
    T value;
    BSTNode<T> left;
    BSTNode<T> right;

    public BSTNode(T x) {
        this.value = x;
        this.left = null;
        this.right = null;
    }

    private boolean find(BSTNode<T> root, T x) {
        if (root == null) {
            return false;
        }
        if (x == root.value) {
            return true;
        }
        if (x < root.value) {
            return find(root.left, x);
        } else {
            return find(root.right, x);
        }
    }

    private BSTNode<T> insert(BSTNode<T> node, T x) {
        if (node == null) {
            return new BSTNode<>(x);
        }
        if (x < node.value) {
            node.left = insert(node.left, x);
        } else {
            node.right = insert(node.right, x);
        }
        return node;
    }

    private BSTNode<T> delete(BSTNode<T> node, T x){
        if (node == null) return null;
        if (x < node.value) {
            node.left = delete(node.left, x);
        } else if (x > node.value) {
            node.right = delete(node.right, x);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.value = findMin(node.right);
            node.right = delete(node.right, node.value)
        }
        return node;
    }

    private T findMin(BSTNode<T> root) {
        if (root.left == null) {
            return root.value;
        }
        return findMin(root.left);
    }
}
