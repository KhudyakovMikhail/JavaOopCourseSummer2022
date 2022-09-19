package ru.academits.khudyakov.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int size;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
    }

    public int size() {
        return size;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void add(T data) {
        if (data == null) {
            throw new NullPointerException("Нельзя вставить null");
        }

        if (root == null) {
            root = new TreeNode<>(data);
            size++;
        } else {
            add(data, root);
        }
    }

    private void add(T data, TreeNode<T> node) {
        TreeNode<T> newNode = new TreeNode<>(data);

        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);

                size++;
            } else {
                add(data, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(newNode);

                size++;
            } else {
                add(data, node.getRight());
            }
        }
    }

    public boolean contains(T data) {
        if (data == null) {
            throw new NullPointerException("Нельзя найти null");
        }

        if (root == null) {
            return false;
        }

        TreeNode<T> current = root;

        while (!data.equals(current.getData())) {
            if (data.compareTo(current.getData()) < 0) {
                if (current.getLeft() == null) {
                    return false;
                }

                current = current.getLeft();
            } else if (data.compareTo(current.getData()) > 0){
                if (current.getRight() == null) {
                    return  false;
                }

                current = current.getRight();
            }
        }

        return true;
    }

    public boolean remove(T data) {
        return false;
    }

    public void breadthTravers() {
        LinkedList<TreeNode<T>> queue = new LinkedList<>();

        queue.addFirst(root);

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.getLast();

            queue.removeLast();

            System.out.print(current.getData() + " ");

            if (current.getLeft() != null) {
                queue.addFirst(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.addFirst(current.getRight());
            }
        }

        System.out.println();
    }

    public void depthTravers() {
        ArrayList<TreeNode<T>> stack = new ArrayList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.get(stack.size() - 1);

            stack.remove(stack.size() - 1);

            System.out.print(current.getData() + " ");

            if (current.getRight() != null) {
                stack.add(current.getRight());
            }

            if (current.getLeft() != null) {
                stack.add(current.getLeft());
            }
        }

        System.out.println();
    }

    public void visit(TreeNode<T> node) {
        System.out.print(node.getData() + " ");

        if (node.getLeft() != null) {
            visit(node.getLeft());
        }

        if (node.getRight() != null) {
            visit(node.getRight());
        }
    }
}
