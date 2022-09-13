package ru.academits.khudyakov.array_list_main;

import ru.academits.khudyakov.array_list.MyArrayList;

public class MyArrayListMain {
    public static void main(String[] args) {
//        MyArrayList<Integer> list1 = new MyArrayList<>(0);
//
//        list1.add(0);
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(2, 5);
//
//        System.out.println("Список 1: " + list1);
//
//        MyArrayList<Integer> list2 = new MyArrayList<>(list1);
//
//        list2.addAll(2, list1);
//
//        System.out.println("Список 2: " + list2);
//
//        MyArrayList<Integer> list3 = new MyArrayList<>();
//
//        list3.add(2);
//        list3.add(3);
//        list3.add(4);
//
//        System.out.println("Список 3: " + list3);
//
//        list2.retainAll(list3);
//        System.out.println("Список 2 содержащий элементы списка 3: " + list2);

        MyArrayList<Integer> list1 = new MyArrayList<>(0);

        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(2, null);
        list1.add(0, 10);
        list1.add(6, 10);
        list1.add(6, null);

        System.out.println(list1);

        MyArrayList<Integer> list2 = new MyArrayList<>(0);

        list2.add(2);
        list2.add(3);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(4);

        System.out.println(list2);

        list1.addAll(4, list2);

        System.out.println(list1);

        System.out.println(list1.remove(Integer.valueOf(10)));
        System.out.println(list1);

        MyArrayList<Integer> list3 = new MyArrayList<>();

        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(null);
        list3.add(6);

        list1.retainAll(list3);
        System.out.println(list1);
    }
}
