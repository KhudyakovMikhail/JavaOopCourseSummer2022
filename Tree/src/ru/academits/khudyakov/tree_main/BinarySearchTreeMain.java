package ru.academits.khudyakov.tree_main;

import ru.academits.khudyakov.tree.BinarySearchTree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.add(30);
        binarySearchTree.add(50);
        binarySearchTree.add(15);
        binarySearchTree.add(10);
        binarySearchTree.add(35);
        binarySearchTree.add(70);
        binarySearchTree.add(20);
        binarySearchTree.add(45);
        binarySearchTree.add(65);
        binarySearchTree.add(5);
        binarySearchTree.add(80);
        binarySearchTree.add(17);
        binarySearchTree.add(25);

        System.out.println("����� ����� ������: " + binarySearchTree.size());

        System.out.println("����� ������ � ������: ");
        binarySearchTree.traverseInBreadth(integer -> System.out.print(integer + " "));

        System.out.println("����� ������ � �������: ");
        binarySearchTree.traverseInDepth(integer -> System.out.print(integer + " "));

        System.out.println("����� ������ � ������� ����������: ");
        binarySearchTree.traverseInDepthRecursive(integer -> System.out.print(integer + " "));
        System.out.println();
    }
}
