package ru.academits.khudyakov.arraylist_main;

import ru.academits.khudyakov.arraylist.MyArrayList;

public class MyArrayListMain {
    public static void main(String[] args) {
        MyArrayList<Integer> myList1 = new MyArrayList<>(0);

        myList1.add(0);
        myList1.add(1);
        myList1.add(2);
        myList1.add(3);
        myList1.add(2, 5);

        System.out.println("Список 1: " + myList1);

        MyArrayList<Integer> myList2 = new MyArrayList<>(myList1);

        myList2.addAll(2, myList1);

        System.out.println("Список 2: " + myList2);

        MyArrayList<Integer> myList3 = new MyArrayList<>();

        myList3.add(2);
        myList3.add(3);
        myList3.add(4);

        System.out.println("Список 3: " + myList3);

        myList2.retainAll(myList3);
        System.out.println("Список 2 содержащий элементы списка 3: " + myList2);
    }
}
