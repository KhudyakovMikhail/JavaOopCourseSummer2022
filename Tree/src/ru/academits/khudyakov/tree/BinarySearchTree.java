package ru.academits.khudyakov.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class BinarySearchTree<T> {
    private final Comparator<? super T> comparator;
    private TreeNode<T> root;
    private int size;

    public BinarySearchTree() {
        comparator = null;
    }

    public BinarySearchTree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private int compare(T data1, T data2) {
        if (comparator != null) {
            return comparator.compare(data1, data2);
        }

        if (data1 == null && data2 == null) {
            return 0;
        }

        if (data1 == null) {
            return -1;
        }

        if (data2 == null) {
            return 1;
        }

        //noinspection unchecked
        Comparable<? super T> comparableData1 = (Comparable<? super T>) data1;

        return comparableData1.compareTo(data2);
    }

    public void add(T data) {
        if (root == null) {
            root = new TreeNode<>(data);
            size++;
        } else {
            TreeNode<T> newNode = new TreeNode<>(data);
            TreeNode<T> currentNode = root;

            while (true) {
                if (compare(data, currentNode.getData()) < 0) {
                    if (currentNode.getLeft() != null) {
                        currentNode = currentNode.getLeft();
                        continue;
                    }

                    currentNode.setLeft(newNode);
                    size++;
                    break;
                }

                if (compare(data, currentNode.getData()) >= 0) {
                    if (currentNode.getRight() != null) {
                        currentNode = currentNode.getRight();
                        continue;
                    }

                    currentNode.setRight(newNode);
                    size++;
                    break;
                }
            }
        }
    }

    public boolean contains(T data) {
        if (root == null) {
            return false;
        }

        TreeNode<T> currentItem = root;

        while (compare(data, currentItem.getData()) != 0) {
            if (compare(data, currentItem.getData()) < 0) {
                if (currentItem.getLeft() == null) {
                    return false;
                }

                currentItem = currentItem.getLeft();
            } else if (compare(data, currentItem.getData()) > 0) {
                if (currentItem.getRight() == null) {
                    return false;
                }

                currentItem = currentItem.getRight();
            }
        }

        return true;
    }

    public boolean remove(T data) {
        if (root == null || !contains(data)) {
            return false;
        }

        size--;

        if (compare(data, root.getData()) == 0) {
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;

                return true;
            }

            if ((root.getLeft() == null && root.getRight() != null) || (root.getRight() == null && root.getLeft() != null)) {
                root = (root.getLeft() == null) ? root.getRight() : root.getLeft();

                return true;
            }

            TreeNode<T> currentItemParent = root.getRight();
            TreeNode<T> currentItem = currentItemParent.getLeft();

            while (currentItem.getLeft() != null) {
                currentItem = currentItem.getLeft();
                currentItemParent = currentItemParent.getLeft();
            }

            if (currentItem.getRight() != null) {
                currentItemParent.setLeft(currentItem.getRight());
            }

            currentItem.setLeft(root.getLeft());
            currentItem.setRight(root.getRight());
            root = currentItem;
        }

        TreeNode<T> removedItemParent = root;
        TreeNode<T> removedItem;

        if (compare(data, root.getData()) < 0) {
            removedItem = root.getLeft();
        } else {
            removedItem = root.getRight();
        }

        while (compare(data, removedItem.getData()) != 0) {
            removedItemParent = removedItem;

            if (compare(data, removedItem.getData()) < 0) {
                removedItem = removedItem.getLeft();
            } else {
                removedItem = removedItem.getRight();
            }
        }

        if (removedItem.getLeft() == null && removedItem.getRight() == null) {
            if (compare(data, removedItemParent.getData()) < 0) {
                removedItemParent.setLeft(null);
            } else {
                removedItemParent.setRight(null);
            }

            return true;
        }

        if ((removedItem.getLeft() == null && removedItem.getRight() != null) || (removedItem.getRight() == null && removedItem.getLeft() != null)) {
            TreeNode<T> removedItemChild = (removedItem.getLeft() == null) ? removedItem.getRight() : removedItem.getLeft();

            if (compare(data, removedItemParent.getData()) < 0) {
                removedItemParent.setLeft(removedItemChild);
            } else {
                removedItemParent.setRight(removedItemChild);
            }

            return true;
        }

        TreeNode<T> minimumLeftChildParent = removedItem.getRight();
        TreeNode<T> minimumLeftChild = minimumLeftChildParent.getLeft();

        if (minimumLeftChild == null) {
            minimumLeftChildParent.setRight(null);
            minimumLeftChildParent.setLeft(removedItem.getLeft());

            if (compare(data, removedItemParent.getData()) < 0) {
                removedItemParent.setLeft(minimumLeftChildParent);
            } else {
                removedItemParent.setRight(minimumLeftChildParent);
            }

            return true;
        }

        while (minimumLeftChild.getLeft() != null) {
            minimumLeftChildParent = minimumLeftChild;
            minimumLeftChild = minimumLeftChild.getLeft();
        }

        if (minimumLeftChild.getRight() != null) {
            minimumLeftChildParent.setLeft(minimumLeftChild.getRight());
        } else {
            minimumLeftChildParent.setLeft(null);
        }

        if (compare(data, removedItemParent.getData()) < 0) {
            removedItemParent.setLeft(minimumLeftChild);
        } else {
            removedItemParent.setRight(minimumLeftChild);
        }

        minimumLeftChild.setLeft(removedItem.getLeft());
        minimumLeftChild.setRight(removedItem.getRight());

        return true;
    }

    public void traverseInBreadth(Consumer<T> consumer) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.remove();

            consumer.accept(current.getData());

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        System.out.println();
    }

    public void traverseInDepth(Consumer<T> consumer) {
        if (root == null) {
            return;
        }

        ArrayList<TreeNode<T>> stack = new ArrayList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.remove(stack.size() - 1);

            consumer.accept(current.getData());

            if (current.getRight() != null) {
                stack.add(current.getRight());
            }

            if (current.getLeft() != null) {
                stack.add(current.getLeft());
            }
        }

        System.out.println();
    }

    public void traverseInDepthRecursive(Consumer<T> consumer) {
        if (root == null) {
            return;
        }

        visit(root, consumer);
    }

    private void visit(TreeNode<T> node, Consumer<T> consumer) {
        consumer.accept(node.getData());

        if (node.getLeft() != null) {
            visit(node.getLeft(), consumer);
        }

        if (node.getRight() != null) {
            visit(node.getRight(), consumer);
        }
    }
}
