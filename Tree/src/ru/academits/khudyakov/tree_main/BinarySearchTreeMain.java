package ru.academits.khudyakov.tree_main;

import ru.academits.khudyakov.tree.BinarySearchTree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.add(30);
        binarySearchTree.add(32);
        binarySearchTree.add(18);
        binarySearchTree.add(10);
        binarySearchTree.add(7);
        binarySearchTree.add(46);
        binarySearchTree.add(35);
        binarySearchTree.add(39);
        binarySearchTree.add(13);
        binarySearchTree.add(20);
        binarySearchTree.add(22);
        binarySearchTree.add(33);
        binarySearchTree.add(19);
        binarySearchTree.add(4);
        binarySearchTree.add(11);
        binarySearchTree.add(29);
        binarySearchTree.add(31);
        binarySearchTree.add(8);
        binarySearchTree.add(21);

        System.out.println("Число узлов дерева: " + binarySearchTree.size());

        System.out.println("Обход дерева в ширину: ");
        binarySearchTree.breadthTravers();

        System.out.println("Обход дерева в глубину: ");
        binarySearchTree.depthTravers();

        System.out.println("Обход дерева в глубину рекурсивно: ");
        binarySearchTree.visit(binarySearchTree.getRoot());
        System.out.println();


    }
}
