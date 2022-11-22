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

            do {
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
            } while (currentNode != null);
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
        return false;
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
