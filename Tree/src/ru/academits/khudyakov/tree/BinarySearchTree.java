package ru.academits.khudyakov.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class BinarySearchTree<T> {
    private Comparator<? super T> comparator;
    private TreeNode<T> root;
    private int size;

    public BinarySearchTree() {
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

    private void add(T data, TreeNode<T> parent) {
        TreeNode<T> newNode = new TreeNode<>(data);

        if (comparator == null) {
            //noinspection unchecked
            Comparable<? super T> addedData = (Comparable<? super T>) data;

            if (addedData.compareTo(parent.getData()) < 0) {
                if (parent.getLeft() == null) {
                    parent.setLeft(newNode);

                    size++;
                } else {
                    add(data, parent.getLeft());
                }
            } else {
                if (parent.getRight() == null) {
                    parent.setRight(newNode);

                    size++;
                } else {
                    add(data, parent.getRight());
                }
            }
        } else {
            if (comparator.compare(data, parent.getData()) < 0) {
                if (parent.getLeft() == null) {
                    parent.setLeft(newNode);

                    size++;
                } else {
                    add(data, parent.getLeft());
                }
            } else {
                if (parent.getRight() == null) {
                    parent.setRight(newNode);

                    size++;
                } else {
                    add(data, parent.getRight());
                }
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

        TreeNode<T> currentItem = root;

        if (comparator == null) {
            //noinspection unchecked
            Comparable<? super T> comparableData = (Comparable<? super T>) data;

            while (!comparableData.equals(currentItem.getData())) {
                if (comparableData.compareTo(currentItem.getData()) < 0) {
                    if (currentItem.getLeft() == null) {
                        return false;
                    }

                    currentItem = currentItem.getLeft();
                } else if (comparableData.compareTo(currentItem.getData()) > 0) {
                    if (currentItem.getRight() == null) {
                        return false;
                    }

                    currentItem = currentItem.getRight();
                }
            }
        } else {
            while (!data.equals(currentItem.getData())) {
                if (comparator.compare(data, currentItem.getData()) < 0) {
                    if (currentItem.getLeft() == null) {
                        return false;
                    }

                    currentItem = currentItem.getLeft();
                } else if (comparator.compare(data, currentItem.getData()) > 0) {
                    if (currentItem.getRight() == null) {
                        return false;
                    }

                    currentItem = currentItem.getRight();
                }
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
